package com.example.demo.controller;

import com.example.demo.entity.Porudzbina;
import com.example.demo.service.PorudzbinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PorudzbinaRestController {

    @Autowired
    private PorudzbinaService porudzbinaService;

    @GetMapping("/api/porudzbine/restoran/{id}")
    public ResponseEntity<List<Porudzbina>> getPorudzbineByRestoran(@PathVariable(name = "id") Long id) {
        List<Porudzbina> porudzbine = porudzbinaService.getPorudzbineByRestoran(id);
        return ResponseEntity.ok(porudzbine);
    }
}