package com.example.demo.controller;

import com.example.demo.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestoranRestController {

    @Autowired
    private RestoranService restoranService;
}