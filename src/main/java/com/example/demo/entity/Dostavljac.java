package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Dostavljac extends Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "dostavljac", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Porudzbina> porudzbine = new HashSet<>();

    public Dostavljac(){}

    public Dostavljac(String korisnickoIme, String lozinka, String ime, String prezime, PolEnum pol, Date datumRodjenja, UlogaEnum uloga) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datumRodjenja, uloga);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Porudzbina> getPorudzbine() {
        return porudzbine;
    }

    public void setPorudzbine(Set<Porudzbina> porudzbine) {
        this.porudzbine = porudzbine;
    }
}
