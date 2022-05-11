package com.example.demo.controller;

import com.example.demo.entity.Artikal;
import com.example.demo.service.ArtikalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArtikalController {

    @Autowired
    private ArtikalService artikalService;

    @PostMapping("/api/create-artikal")
    public String createArtikal(@RequestBody Artikal artikal) {
        this.artikalService.saveArtikal(artikal);
        return "Uspesno sacuvan artikal!";
    }

    @DeleteMapping("/api/delete-artikal/{id}")
    public String deleteArtikal(@PathVariable(name = "id") Long id) {
        Artikal artikal = artikalService.findOne(id);
        this.artikalService.deleteArtikal(artikal);
        return "Uspesno obrisan artikal!";
    }

    @PostMapping("/api/edit-artikal")
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
