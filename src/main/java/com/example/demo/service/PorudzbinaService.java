package com.example.demo.service;

import com.example.demo.entity.Porudzbina;
import com.example.demo.repository.PorudzbinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorudzbinaService {

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    public List<Porudzbina> getPorudzbineByRestoran(Long restoranId) {
        return porudzbinaRepository.getByRestoranId(restoranId);
    }

    public List<Porudzbina> getPorudzbineByKupac(Long kupacId) {
        return porudzbinaRepository.getByKupacId(kupacId);
    }

    public List<Porudzbina> getPorudzbineByStatus(String status) {
        return porudzbinaRepository.getByStatus(status);
    }

    public Porudzbina savePorudzbina(Porudzbina porudzbina) {
        return this.porudzbinaRepository.save(porudzbina);
    }
}
