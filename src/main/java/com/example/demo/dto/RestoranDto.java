package com.example.demo.dto;

import com.example.demo.entity.Artikal;
import com.example.demo.entity.Komentar;

import java.util.List;
import java.util.Set;

public class RestoranDto {

    private String naziv;

    private String tip;

    private Long lokacijaId;

    private List<Komentar> komentari;

    private Set<Artikal> artikli;

    private String status;

    public RestoranDto() {
    }

    public RestoranDto(String naziv, String tip, String status, Long lokacijaId, List<Komentar> komentari, Set<Artikal> artikli) {
        this.naziv = naziv;
        this.tip = tip;
        this.status = status;
        this.lokacijaId = lokacijaId;
        this.komentari = komentari;
        this.artikli = artikli;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getLokacijaId() {
        return lokacijaId;
    }

    public void setLokacijaId(Long lokacijaId) {
        this.lokacijaId = lokacijaId;
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
