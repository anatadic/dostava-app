package com.example.demo.service;

import com.example.demo.entity.Lokacija;
import com.example.demo.repository.LokacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LokacijaService {

    @Autowired
    LokacijaRepository lokacijaRepository;

    public Lokacija getLokacijaByAdresa(String adresa) {
        return lokacijaRepository.getByAdresa(adresa);
    }

    public void saveLokacija(Lokacija lokacija) {
        lokacijaRepository.save(lokacija);
    }
}
