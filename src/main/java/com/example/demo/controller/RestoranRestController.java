package com.example.demo.controller;

import com.example.demo.dto.RestoranDto;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class RestoranRestController {

    @Autowired
    private RestoranService restoranService;

    @Autowired
    private MenadzerService menadzerService;

    @Autowired
    PorudzbinaService porudzbinaService;

    @Autowired
    LokacijaService lokacijaService;

    @Autowired
    ArtikalService artikalService;

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
        if(restoran.getStatus() != null) {
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

    @DeleteMapping("/api/restoran/delete/{id}")
    public ResponseEntity deleteRestoran(@PathVariable Long id, HttpSession session) {

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            System.out.println("Nema sesije");
            return new ResponseEntity("Morate biti ulogovani", HttpStatus.BAD_REQUEST);
        }

        if(!loggedKorisnik.getUloga().toString().equals(String.valueOf(UlogaEnum.ADMIN))) {
            return new ResponseEntity("Nije dozvoljeno izvrsiti ovu akciju.", HttpStatus.BAD_REQUEST);
        }

        Restoran restoran = restoranService.findOne(id);
        restoran.setArtikli(null);

        List<Artikal> artikalList = artikalService.findByRestoran(id);

        for(Artikal artikal: artikalList) {
            artikal.setRestoran(null);
            artikalService.saveArtikal(artikal);
        }

        List<Komentar> komentarList = komentarService.getAllByRestoranId(id);

        for(Komentar komentar: komentarList) {
            komentar.setRestoran(null);
            komentarService.deleteKomentar(komentar);
        }

        List<Menadzer> menadzerList = menadzerService.findAllByRestoran(id);

        for(Menadzer menadzer: menadzerList) {
            menadzer.setRestoran(null);
            menadzerService.saveMenadzer(menadzer);
        }
        List<Porudzbina> porudzbinaList = porudzbinaService.getPorudzbineByRestoran(id);

        for(Porudzbina porudzbina: porudzbinaList) {
            porudzbina.setRestoran(null);
            porudzbinaService.savePorudzbina(porudzbina);
        }


        restoranService.saveRestoran(restoran);
        restoranService.deleteRestoran(restoran);
        return ResponseEntity.ok("Uspesno obrisan restoran");
    }
}
