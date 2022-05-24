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

        if (restoranDto.getNaziv().isEmpty() || restoranDto.getTipRestorana().isEmpty()) {
            return new ResponseEntity("Neispravno uneti podaci", HttpStatus.BAD_REQUEST);
        }

        Restoran restoran = new Restoran();
        restoran.setNaziv(restoranDto.getNaziv());
        restoran.setStatus(RestoranStatusEnum.valueOf(restoranDto.getStatus().toUpperCase()));
        restoran.setTipRestorana(restoran.getTipRestorana());

        Lokacija lokacija = lokacijaService.getLokacijaById(restoranDto.getLokacijaId());
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

    @GetMapping("/api/restorani/naziv/{naziv}")
    public ResponseEntity<Restoran> getByNaziv(@PathVariable String naziv) {
        Restoran restoran = restoranService.getByNaziv(naziv);
        return ResponseEntity.ok(restoran);
    }

    @GetMapping("/api/restorani/lokacija/{lokacijaId}")
    public ResponseEntity<Restoran> getByNaziv(@PathVariable("lokacijaId") Long lokacijaId) {
        Restoran restoran = restoranService.getByLokacija(lokacijaId);
        return ResponseEntity.ok(restoran);
    }

    @GetMapping("/api/restorani/tip/{tip}")
    public ResponseEntity<List<Restoran>> getByTip(@PathVariable("tip") String tip) {
        List<Restoran> restorani = restoranService.getByTip(tip);
        return ResponseEntity.ok(restorani);
    }

}
