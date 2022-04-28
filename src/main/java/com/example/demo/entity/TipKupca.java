package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class TipKupca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ime;
    private int popust;
    private int trazeniBrojBodova;

    public TipKupca(String ime, int popust, int trazeniBrojBodova) {
        this.ime = ime;
        this.popust = popust;
        this.trazeniBrojBodova = trazeniBrojBodova;
    }

    public TipKupca(){}

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    public int getTrazeniBrojBodova() {
        return trazeniBrojBodova;
    }

    public void setTrazeniBrojBodova(int trazeniBrojBodova) {
        this.trazeniBrojBodova = trazeniBrojBodova;
    }
}
