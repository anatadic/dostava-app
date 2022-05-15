package com.example.demo.controller;

import com.example.demo.entity.Artikal;
import com.example.demo.service.ArtikalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArtikalController {

    @Autowired
    private ArtikalService artikalService;

    @PostMapping("/api/artikal/create")
    public String createArtikal(@RequestBody Artikal artikal) {
        this.artikalService.saveArtikal(artikal);
        return "Uspesno sacuvan artikal!";
    }

    @DeleteMapping("/api/artikal/delete/{id}")
    public String deleteArtikal(@PathVariable(name = "id") Long id) {
        Artikal artikal = artikalService.findOne(id);
        this.artikalService.deleteArtikal(artikal);
        return "Uspesno obrisan artikal!";
    }

    @PutMapping("/api/artikal/edit")
    public String editArtikal(@RequestBody Artikal artikal) {
        Artikal editArtikal = artikalService.findOne(artikal.getId());
        editArtikal.setCena(artikal.getCena());
        editArtikal.setKolicina(artikal.getKolicina());
        editArtikal.setNaziv(artikal.getNaziv());
        editArtikal.setOpis(artikal.getOpis());
        editArtikal.setRestoran(artikal.getRestoran());
        editArtikal.setTip(artikal.getTip());
        this.artikalService.saveArtikal(editArtikal);
        return "Uspesno izmenjen artikal!";
    }
}
