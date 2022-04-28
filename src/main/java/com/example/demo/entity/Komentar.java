package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Komentar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "kupac_id")
    private Kupac kupac;

    @OneToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    private String tekst;

    private int ocena;

    public Komentar() {}

    public Komentar(Kupac kupac, Restoran restoran, String tekst, int ocena) {
        this.kupac = kupac;
        this.restoran = restoran;
        this.tekst = tekst;
        this.ocena = ocena;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
}
