package com.example.demo.dto;

import com.example.demo.entity.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PorudzbinaDto {

    private Long id;

    private Set<Artikal> artikli = new HashSet<>();

    private Long restoranId;

    private Date datumIVreme;

    private double cena;

    private String status;

    private Long kupacId;

    private Long dostavljacId;

    public PorudzbinaDto() {
    }

    public PorudzbinaDto(Set<Artikal> artikli, Long restoranId, Date datumIVreme, double cena, String status, Long kupacId, Long dostavljacId) {
        this.artikli = artikli;
        this.restoranId = restoranId;
        this.datumIVreme = datumIVreme;
        this.cena = cena;
        this.status = status;
        this.kupacId = kupacId;
        this.dostavljacId = dostavljacId;
    }

    public Long getId() {
        return id;
    }

    public Set<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(Set<Artikal> artikli) {
        this.artikli = artikli;
    }

    public Long getRestoranId() {
        return restoranId;
    }

    public void setRestoran(Long restoranId) {
        this.restoranId = restoranId;
    }

    public Date getDatumIVreme() {
        return datumIVreme;
    }

    public void setDatumIVreme(Date datumIVreme) {
        this.datumIVreme = datumIVreme;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getKupacId() {
        return kupacId;
    }

    public void setKupacId(Long kupacId) {
        this.kupacId = kupacId;
    }

    public Long getDostavljacId() {
        return dostavljacId;
    }

    public void setDostavljacId(Long dostavljacId) {
        this.dostavljacId = dostavljacId;
    }
}
