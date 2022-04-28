package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class TipKupca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipKupcaEnum ime;

    private int popust;

    private int trazeniBrojBodova;

    public TipKupca(TipKupcaEnum ime, int popust, int trazeniBrojBodova) {
        this.ime = ime;
        this.popust = popust;
        this.trazeniBrojBodova = trazeniBrojBodova;
    }

    public TipKupca(){}

    public TipKupcaEnum getIme() {
        return ime;
    }

    public void setIme(TipKupcaEnum ime) {
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
