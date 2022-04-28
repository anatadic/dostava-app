package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Kupac extends Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "kupac", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Porudzbina> svePorudzbine = new HashSet<>();

    private int brojSakupljenihBodova;

    @OneToOne
    @JoinColumn(name = "tip_kupca_id")
    private TipKupca tipKupca;

    public Kupac(){}

    public Kupac(String korisnickoIme, String lozinka, String ime, String prezime, PolEnum pol, Date datumRodjenja, UlogaEnum uloga, int brojSakupljenihBodova, TipKupca tipKupca) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datumRodjenja, uloga);
        this.brojSakupljenihBodova = brojSakupljenihBodova;
        this.tipKupca = tipKupca;
    }

    public Set<Porudzbina> getSvePorudzbine() {
        return svePorudzbine;
    }

    public void setSvePorudzbine(Set<Porudzbina> svePorudzbine) {
        this.svePorudzbine = svePorudzbine;
    }

    public int getBrojSakupljenihBodova() {
        return brojSakupljenihBodova;
    }

    public void setBrojSakupljenihBodova(int brojSakupljenihBodova) {
        this.brojSakupljenihBodova = brojSakupljenihBodova;
    }

    public TipKupca getTipKupca() {
        return tipKupca;
    }

    public void setTipKupca(TipKupca tipKupca) {
        this.tipKupca = tipKupca;
    }
}
