package com.example.demo.dto;

public class RestoranMenadzerDto {

    private Long menadzerId;

    private Long restoranId;

    public RestoranMenadzerDto() {
    }

    public RestoranMenadzerDto(Long menadzerId, Long restoranId) {
        this.menadzerId = menadzerId;
        this.restoranId = restoranId;
    }

    public Long getMenadzerId() {
        return menadzerId;
    }

    public void setMenadzerId(Long menadzerId) {
        this.menadzerId = menadzerId;
    }

    public Long getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Long restoranId) {
        this.restoranId = restoranId;
    }
}
