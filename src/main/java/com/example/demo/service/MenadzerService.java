package com.example.demo.service;


import com.example.demo.entity.Menadzer;
import com.example.demo.repository.MenadzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenadzerService {

    @Autowired
    MenadzerRepository menadzerRepository;


    public List<Menadzer> findAllByRestoran(Long id) {
        return menadzerRepository.findAllByRestoranId(id);
    }

    public Menadzer saveMenadzer(Menadzer menadzer) {
        return menadzerRepository.save(menadzer);
    }

}
