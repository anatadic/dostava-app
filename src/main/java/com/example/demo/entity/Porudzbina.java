package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Porudzbina implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid; //uuid generator
    @OneToMany(mappedBy = "porudzbina", cascade = CascadeType.ALL)
    private Set<Artikal> artikli = new HashSet<>(); //MANYTOMANY
    //posebna klasa stavkaPorudzbine koja ima artikal i kolicina
    @OneToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;
    private Date datumIVreme;
    private double cena;
    private String status; //enumeracija

    @ManyToOne
    @JoinColumn(name="kupac_id")
    private Kupac kupac;

    @ManyToOne
    @JoinColumn(name="dostavljac_id")
    private Dostavljac dostavljac;

    public Porudzbina(){}

    public Porudzbina(Restoran restoran, Date datumIVreme, double cena, Kupac kupac, String status) {
        this.uuid = uuid;
        this.restoran = restoran;
        this.datumIVreme = datumIVreme;
        this.cena = cena;
        this.kupac = kupac;
        this.status = status;
    }

    public Set<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(Set<Artikal> artikli) {
        this.artikli = artikli;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
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

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Dostavljac getDostavljac() {
        return dostavljac;
    }

    public void setDostavljac(Dostavljac dostavljac) {
        this.dostavljac = dostavljac;
    }
}
