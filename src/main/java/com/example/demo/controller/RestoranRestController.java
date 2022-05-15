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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> createRestoran(@RequestBody RestoranDto restoranDto) {

        if (restoranDto.getNaziv().isEmpty() || restoranDto.getTip().isEmpty() || restoranDto.getLokacijaId() == null) {
            return new ResponseEntity("Neispravno uneti podaci", HttpStatus.BAD_REQUEST);
        }

        Restoran restoran = new Restoran();
        restoran.setNaziv(restoranDto.getNaziv());
        restoran.setTipRestorana(restoran.getTipRestorana());

        Lokacija lokacija = lokacijaService.getLokacijaById(restoranDto.getLokacijaId());
        restoran.setLokacija(lokacija);

        restoranService.saveRestoran(restoran);

        return ResponseEntity.ok("Uspesno dodat restoran!");
    }

    @GetMapping("/api/restorani/{id}")
    public ResponseEntity<RestoranDto> getById(@PathParam("id") Long id) {

        Restoran restoran = restoranService.findOne(id);
        List<Komentar> komentari = komentarService.getAllByRestoranId(id);

        RestoranDto restoranDto = new RestoranDto();
        restoranDto.setNaziv(restoran.getNaziv());
        restoranDto.setTip(restoran.getTipRestorana());
        restoranDto.setStatus(restoran.getStatus().toString());
        restoranDto.setLokacijaId(restoran.getLokacija().getId());
        restoranDto.setArtikli(restoran.getArtikli());
        restoranDto.setKomentari(komentari);

        return ResponseEntity.ok(restoranDto);
    }

    @GetMapping("/api/restorani")
    public ResponseEntity<List<Restoran>> getRestorani() {
        List<Restoran> restorani = restoranService.getAll();
        return ResponseEntity.ok(restorani);
    }

    @GetMapping("/api/restorani/{naziv}")
    public ResponseEntity<Restoran> getByNaziv(@PathParam("naziv") String naziv) {
        Restoran restoran = restoranService.getByNaziv(naziv);
        return ResponseEntity.ok(restoran);
    }

    @GetMapping("/api/restorani/{lokacija}")
    public ResponseEntity<Restoran> getByNaziv(@PathParam("lokacija") Long lokacijaId) {
        Restoran restoran = restoranService.getByLokacija(lokacijaId);
        return ResponseEntity.ok(restoran);
    }

    @GetMapping("/api/restorani/{tip}")
    public ResponseEntity<List<Restoran>> getByTip(@PathParam("tip") String tip) {
        List<Restoran> restorani = restoranService.getByTip(tip);
        return ResponseEntity.ok(restorani);
    }

}
