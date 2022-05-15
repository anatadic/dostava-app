package com.example.demo.controller;

import com.example.demo.dto.RestoranMenadzerDto;
import com.example.demo.entity.Menadzer;
import com.example.demo.entity.Restoran;
import com.example.demo.service.KorisnikService;
import com.example.demo.service.MenadzerService;
import com.example.demo.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenadzerRestController {

    @Autowired
    private MenadzerService menadzerService;

    @Autowired
    private RestoranService restoranService;

    @Autowired
    private KorisnikService korisnikService;

    @PostMapping("/api/menadzer/add-restoran")
    public ResponseEntity<String> addMenadzerRestoran(@RequestBody RestoranMenadzerDto restoranMenadzerDto) {

        Restoran restoran = restoranService.findOne(restoranMenadzerDto.getRestoranId());
        Menadzer menadzer = (Menadzer) korisnikService.findOne(restoranMenadzerDto.getMenadzerId());
        menadzer.setRestoran(restoran);
        menadzerService.saveMenadzer(menadzer);

        return ResponseEntity.ok("Uspesno dodeljen restoran menadzeru!");
    }
}
