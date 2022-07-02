package com.example.demo.controller;

import com.example.demo.dto.RestoranDto;
import com.example.demo.entity.*;
import com.example.demo.service.KomentarService;
import com.example.demo.service.KorisnikService;
import com.example.demo.service.LokacijaService;
import com.example.demo.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class RestoranRestController {

    @Autowired
    private RestoranService restoranService;

    @Autowired
    LokacijaService lokacijaService;

    @Autowired
    KorisnikService korisnikService;

    @Autowired
    KomentarService komentarService;

    @PostMapping("/api/restoran/create")
    public ResponseEntity<String> createRestoran(@RequestBody RestoranDto restoranDto, HttpSession session) {

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            System.out.println("Nema sesije");
            return new ResponseEntity("Morate biti ulogovani", HttpStatus.BAD_REQUEST);
        }

        if(!loggedKorisnik.getUloga().toString().equals(String.valueOf(UlogaEnum.ADMIN))) {
            return new ResponseEntity("Nije dozvoljen pristup ovim podacima", HttpStatus.BAD_REQUEST);
        }

        if (restoranDto.getNaziv().isEmpty() || restoranDto.getTipRestorana().isEmpty()) {
            return new ResponseEntity("Neispravno uneti podaci", HttpStatus.BAD_REQUEST);
        }

        Restoran restoran = new Restoran();
        restoran.setNaziv(restoranDto.getNaziv());

        if(restoranDto.getStatus() != null) {
            restoran.setStatus(RestoranStatusEnum.valueOf(restoranDto.getStatus().toUpperCase()));
        }

        restoran.setTipRestorana(restoranDto.getTipRestorana());

        Lokacija lokacija = lokacijaService.getLokacijaByAdresa(restoranDto.getLokacija());
        if (lokacija == null) {
            lokacija = new Lokacija();
            lokacija.setAdresa(restoranDto.getLokacija());
            lokacijaService.saveLokacija(lokacija);
        }
        restoran.setLokacija(lokacija);

        restoranService.saveRestoran(restoran);

        return ResponseEntity.ok("Uspesno dodat restoran!");
    }

    @GetMapping("/api/restorani/{id}")
    public ResponseEntity<RestoranDto> getById(@PathVariable("id") Long id) {

        Restoran restoran = restoranService.findOne(id);
        List<Komentar> komentari = komentarService.getAllByRestoranId(id);

        RestoranDto restoranDto = new RestoranDto();
        restoranDto.setNaziv(restoran.getNaziv());
        restoranDto.setTipRestorana(restoran.getTipRestorana());
        if(restoranDto.getStatus() != null) {
            restoranDto.setStatus(restoran.getStatus().toString());
        }
        restoranDto.setLokacija(restoran.getLokacija().getAdresa());
        restoranDto.setArtikli(restoran.getArtikli());
        restoranDto.setKomentari(komentari);

        return ResponseEntity.ok(restoranDto);
    }

    @GetMapping("/api/restorani")
    public ResponseEntity<List<Restoran>> getRestorani() {
        List<Restoran> restorani = restoranService.getAll();
        return ResponseEntity.ok(restorani);
    }

    @PostMapping("/api/restorani/pretraga")
    public ResponseEntity<List<Restoran>> getByNazivTipLokacija(@RequestBody RestoranDto restoranDto) {
        List<Restoran> restoran = restoranService.findByNazivAndTipAndLokacija(restoranDto.getNaziv(), restoranDto.getTipRestorana(), restoranDto.getLokacija());
        return ResponseEntity.ok(restoran);
    }
}
