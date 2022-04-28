package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "korisnickoIme", unique = true)
    private String korisnickoIme;

    private String lozinka;

    private String ime;

    private String prezime;

    @Enumerated(EnumType.STRING)
    private PolEnum pol;

    private Date datumRodjenja;

    @Enumerated(EnumType.STRING)
    private UlogaEnum uloga;

    public Korisnik(){}

    public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, PolEnum pol, Date datumRodjenja, UlogaEnum uloga) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public PolEnum getPol() {
        return pol;
    }

    public void setPol(PolEnum pol) {
        this.pol = pol;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public UlogaEnum getUloga() {
        return uloga;
    }

    public void setUloga(UlogaEnum uloga) {
        this.uloga = uloga;
    }
}
