package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Lokacija implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "duzina")
    private double geografskaDuzina;
    @Column(name = "sirina")
    private double geografskaSirina;
    private String adresa;

    public Lokacija(double geografskaDuzina, double geografskaSirina, String adresa) {
        this.geografskaDuzina = geografskaDuzina;
        this.geografskaSirina = geografskaSirina;
        this.adresa = adresa;
    }

    public Lokacija(){}

    public double getGeografskaDuzina() {
        return geografskaDuzina;
    }

    public void setGeografskaDuzina(double geografskaDuzina) {
        this.geografskaDuzina = geografskaDuzina;
    }

    public double getGeografskaSirina() {
        return geografskaSirina;
    }

    public void setGeografskaSirina(double geografskaSirina) {
        this.geografskaSirina = geografskaSirina;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
