package com.example.demo.dto;

import com.example.demo.entity.Artikal;
import com.example.demo.entity.Komentar;

import java.util.List;
import java.util.Set;

public class RestoranDto {

    private String naziv;

    private String tipRestorana;

    private String lokacija;

    private List<Komentar> komentari;

    private Set<Artikal> artikli;

    private String status;

    public RestoranDto() {
    }

    public RestoranDto(String naziv, String tipRestorana, String status, String lokacija, List<Komentar> komentari, Set<Artikal> artikli) {
        this.naziv = naziv;
        this.tipRestorana = tipRestorana;
        this.status = status;
        this.lokacija = lokacija;
        this.komentari = komentari;
        this.artikli = artikli;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTipRestorana() {
        return tipRestorana;
    }

    public void setTipRestorana(String tipRestorana) {
        this.tipRestorana = tipRestorana;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public List<Komentar> getKomentari() {
        return komentari;
    }

    public void setKomentari(List<Komentar> komentari) {
        this.komentari = komentari;
    }

    public Set<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(Set<Artikal> artikli) {
        this.artikli = artikli;
    }
}
