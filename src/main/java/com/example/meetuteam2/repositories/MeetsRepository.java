package com.example.meetuteam2.repositories;

import com.example.meetuteam2.entities.Meets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetsRepository extends JpaRepository<Meets, Long> {
    @Query("SELECT m FROM Meets m WHERE recordStatus = 'A'")
    List<Meets> findAllActiveMeets();
    @Query("SELECT m FROM Meets m WHERE recordStatus = 'A' AND id = ?1")
    List<Meets> findActiveMeetsById(Long id);

}
