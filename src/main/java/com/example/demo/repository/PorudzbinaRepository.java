package com.example.demo.repository;

import com.example.demo.entity.Porudzbina;
import com.example.demo.entity.StatusPorudzbineEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Long> {
    List<Porudzbina> getByRestoranId(Long restoranId);

    List<Porudzbina> getByKupacId(Long kupacId);

    List<Porudzbina> getByStatus(StatusPorudzbineEnum status);

    List<Porudzbina> getByDostavljacId(Long dostavljacId);

    Optional<Porudzbina> findByUuid(UUID uuid);

    @Query("SELECT p FROM Porudzbina p JOIN p.artikli s WHERE s.id = :id")
    List<Porudzbina> getByArtikalId(Long id);
}
