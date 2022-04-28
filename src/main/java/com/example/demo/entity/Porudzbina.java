package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Porudzbina implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID uuid;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "stavkePorudzbine", joinColumns = {@JoinColumn(name = "porudzbina_id", referencedColumnName = "uuid")},
            inverseJoinColumns = {@JoinColumn(name = "artikal_id", referencedColumnName = "id")})
    private Set<Artikal> artikli = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    private Date datumIVreme;

    private double cena;

    @Enumerated(EnumType.STRING)
    private StatusPorudzbineEnum status;

    @ManyToOne
    @JoinColumn(name = "kupac_id")
    private Kupac kupac;

    @ManyToOne
    @JoinColumn(name = "dostavljac_id")
    private Dostavljac dostavljac;

    public Porudzbina() {
    }

    public Porudzbina(Restoran restoran, Date datumIVreme, double cena, Kupac kupac, StatusPorudzbineEnum status) {
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

    public StatusPorudzbineEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPorudzbineEnum status) {
        this.status = status;
    }

    public Dostavljac getDostavljac() {
        return dostavljac;
    }

    public void setDostavljac(Dostavljac dostavljac) {
        this.dostavljac = dostavljac;
    }
}
