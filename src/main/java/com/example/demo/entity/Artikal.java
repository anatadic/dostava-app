package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Artikal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    private double cena;
    private String tip; //enum
    private double kolicina;
    private String opis;

    @ManyToOne
    @JoinColumn(name="restoran_id")
    private Restoran restoran;

    @ManyToOne
    @JoinColumn(name="porudzbina_id")
    private Porudzbina porudzbina; //da ne bude bidirekciona


    public Artikal() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String nazivArtikla) {
        this.naziv = nazivArtikla;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
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

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public Porudzbina getPorudzbina() {
        return porudzbina;
    }

    public void setPorudzbina(Porudzbina porudzbina) {
        this.porudzbina = porudzbina;
    }
}
