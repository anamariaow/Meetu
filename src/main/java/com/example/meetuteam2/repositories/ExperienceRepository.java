package com.example.meetuteam2.repositories;

import com.example.meetuteam2.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    @Query("SELECT e FROM Experience e WHERE recordStatus = 'A'")
    List<Experience> findAllActiveExperiences();
}
