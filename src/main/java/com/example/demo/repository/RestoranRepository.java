package com.example.demo.repository;

import com.example.demo.entity.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestoranRepository extends JpaRepository<Restoran, Long> {

    @Query("SELECT r FROM Restoran r WHERE r.naziv LIKE CONCAT('%', ?1,'%') and r.tipRestorana LIKE CONCAT('%', ?2,'%') and r.lokacija LIKE CONCAT('%', ?3,'%')")
    List<Restoran> findByNazivAndTipAndLokacija(String naziv, String tip, String lokacija);
}
