package com.example.demo.controller;

import com.example.demo.dto.ArtikalDto;
import com.example.demo.entity.Artikal;
import com.example.demo.entity.Porudzbina;
import com.example.demo.entity.Restoran;
import com.example.demo.entity.TipArtiklaEnum;
import com.example.demo.service.ArtikalService;
import com.example.demo.service.PorudzbinaService;
import com.example.demo.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ArtikalController {

    @Autowired
    private ArtikalService artikalService;

    @Autowired
    private RestoranService restoranService;

    @Autowired
    private PorudzbinaService porudzbinaService;

    @PostMapping("/api/artikal/create")
    public String createArtikal(@RequestBody ArtikalDto artikalDto) {
        Artikal artikal = new Artikal();
        artikal.setNaziv(artikalDto.getNaziv());
        artikal.setCena(artikalDto.getCena());
        artikal.setTip(TipArtiklaEnum.valueOf(artikalDto.getTip().toUpperCase()));
        artikal.setOpis(artikalDto.getOpis());
        artikal.setSlika(artikalDto.getSlika());

        Restoran restoran = restoranService.findOne(artikalDto.getRestoranId());
        artikal.setRestoran(restoran);

        this.artikalService.saveArtikal(artikal);
        return "Uspesno sacuvan artikal!";
    }

    @DeleteMapping("/api/artikal/delete/{id}")
    public String deleteArtikal(@PathVariable(name = "id") Long id) {

        List<Porudzbina> svePorudzbine = porudzbinaService.getByArtikalId(id);

        for (Porudzbina porudzbina : svePorudzbine) {
            Set<Artikal> artikli = (porudzbina.getArtikli());
            for(Artikal artikal: artikli) {
                if(artikal.getId() == id) {
                    artikli.remove(artikal);
                }
            }
            porudzbina.setArtikli(artikli);
            porudzbinaService.savePorudzbina(porudzbina);
        }

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
        editArtikal.setTip(artikal.getTip());
        this.artikalService.saveArtikal(editArtikal);
        return "Uspesno izmenjen artikal!";
    }
}
