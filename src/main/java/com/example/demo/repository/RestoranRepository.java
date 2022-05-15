package com.example.demo.repository;

import com.example.demo.entity.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestoranRepository extends JpaRepository<Restoran, Long> {
    Restoran getByNaziv(String naziv);

    List<Restoran> getByTipRestorana(String tipRestorana);

    Restoran getByLokacijaId(Long lokacijaId);
}
