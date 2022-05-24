package com.example.demo.service;

import com.example.demo.entity.Porudzbina;
import com.example.demo.entity.StatusPorudzbineEnum;
import com.example.demo.repository.PorudzbinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PorudzbinaService {

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    public List<Porudzbina> getPorudzbineByRestoran(Long restoranId) {
        return porudzbinaRepository.getByRestoranId(restoranId);
    }

    public Porudzbina findOne(UUID id) {
        Optional<Porudzbina> porudzbina = porudzbinaRepository.findByUuid(id);
        if (porudzbina.isPresent())
            return porudzbina.get();

        return null;
    }

    public List<Porudzbina> getPorudzbineByKupac(Long kupacId) {
        return porudzbinaRepository.getByKupacId(kupacId);
    }

    public List<Porudzbina> getPorudzbineByStatus(StatusPorudzbineEnum status) {
        return porudzbinaRepository.getByStatus(status);
    }

    public List<Porudzbina> getPorudzbineByDostavljac(Long dostavljacId) {
        return porudzbinaRepository.getByDostavljacId(dostavljacId);
    }

    public Porudzbina savePorudzbina(Porudzbina porudzbina) {
        return this.porudzbinaRepository.save(porudzbina);
    }

    public List<Porudzbina> getByArtikalId(Long id) {
        return porudzbinaRepository.getByArtikalId(id);
    }
}
