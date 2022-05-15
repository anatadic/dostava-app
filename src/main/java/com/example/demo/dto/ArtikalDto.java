package com.example.demo.dto;

public class ArtikalDto {

    private String naziv;

    private double cena;

    private String slika;

    private String tip;

    private double kolicina;

    private String opis;

    private Long restoranId;

    public ArtikalDto() {
    }

    public ArtikalDto(String naziv, double cena, String slika, String tip, double kolicina, String opis, Long restoranId) {
        this.naziv = naziv;
        this.cena = cena;
        this.slika = slika;
        this.tip = tip;
        this.kolicina = kolicina;
        this.opis = opis;
        this.restoranId = restoranId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Long getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Long restoranId) {
        this.restoranId = restoranId;
    }
}
