package com.example.demo.controller;

import com.example.demo.dto.ArtikalDto;
import com.example.demo.dto.PorudzbinaDto;
import com.example.demo.entity.*;
import com.example.demo.service.KorisnikService;
import com.example.demo.service.PorudzbinaService;
import com.example.demo.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PorudzbinaRestController {

    @Autowired
    private PorudzbinaService porudzbinaService;

    @Autowired
    RestoranService restoranService;

    @Autowired
    KorisnikService korisnikService;

    @GetMapping("/api/porudzbine/restoran/{id}")
    public ResponseEntity<List<Porudzbina>> getPorudzbineByRestoran(@PathVariable(name = "id") Long id) {
        List<Porudzbina> porudzbine = porudzbinaService.getPorudzbineByRestoran(id);
        return ResponseEntity.ok(porudzbine);
    }

    @GetMapping("/api/porudzbine/kupac/{id}")
    public ResponseEntity<List<Porudzbina>> getPorudzbineByKupac(@PathVariable(name = "id") Long id) {
        List<Porudzbina> porudzbine = porudzbinaService.getPorudzbineByKupac(id);
        return ResponseEntity.ok(porudzbine);
    }

    @GetMapping("/api/porudzbine/status/{status}")
    public ResponseEntity<List<Porudzbina>> getPorudzbineByKupac(@PathVariable(name = "status") String status) {
        List<Porudzbina> porudzbine = porudzbinaService.getPorudzbineByStatus(status);
        return ResponseEntity.ok(porudzbine);
    }

    @PostMapping("/api/porudzbina/create")
    public String createPorudzbina(@RequestBody PorudzbinaDto porudzbinaDto) {
        Porudzbina porudzbina = new Porudzbina();
        porudzbina.setArtikli(porudzbinaDto.getArtikli());
        porudzbina.setCena(porudzbinaDto.getCena());

        Restoran restoran = restoranService.findOne(porudzbinaDto.getRestoranId());
        porudzbina.setRestoran(restoran);

        porudzbina.setDatumIVreme(porudzbina.getDatumIVreme());
        porudzbina.setStatus(StatusPorudzbineEnum.OBRADA);

        Kupac kupac = (Kupac) korisnikService.findOne(porudzbinaDto.getKupacId());
        porudzbina.setKupac(kupac);

        this.porudzbinaService.savePorudzbina(porudzbina);
        return "Uspesno kreirana porudzbina!";
    }

    @PutMapping("/api/porudzbina/edit")
    public String editPorudzbina(@RequestBody PorudzbinaDto porudzbinaDto) {
        Porudzbina porudzbina = porudzbinaService.findOne(porudzbinaDto.getId());
        porudzbina.setStatus(StatusPorudzbineEnum.valueOf(porudzbinaDto.getStatus().toUpperCase()));

        if (porudzbinaDto.getDostavljacId() != null) {
            Dostavljac dostavljac = (Dostavljac) korisnikService.findOne(porudzbinaDto.getDostavljacId());
            porudzbina.setDostavljac(dostavljac);
        }
        this.porudzbinaService.savePorudzbina(porudzbina);
        return "Uspesno izmenjena porudzbina!";
    }
}