package com.example.demo.service;

import com.example.demo.entity.Porudzbina;
import com.example.demo.entity.Restoran;
import com.example.demo.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestoranService {

    @Autowired
    private RestoranRepository restoranRepository;

    public Restoran saveRestoran(Restoran restoran) {
        return restoranRepository.save(restoran);
    }

    public Restoran findOne(Long id) {
        Optional<Restoran> restoran = restoranRepository.findById(id);
        if (restoran.isPresent())
            return restoran.get();

        return null;
    }

    public List<Restoran> getAll() {
        return restoranRepository.findAll();
    }

    public List<Restoran> findByNazivAndTipAndLokacija(String naziv, String tip, String lokacija) {
        return restoranRepository.findByNazivAndTipAndLokacija(naziv, tip, lokacija);
    }

    public void deleteRestoran(Restoran restoran) {
        restoranRepository.delete(restoran);
    }
}
