package com.example.meetuteam2.repositories;

import com.example.meetuteam2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExperienceRepository extends JpaRepository<User, Long> {
    @Query("SELECT e FROM Experience e WHERE recordStatus = 'A'")
    List<User> findAllActiveExperiences();
    @Query("SELECT e FROM Experience e WHERE recordStatus = 'A' AND id = ?1")
    Optional<User> findActiveExperienceById(Long id);
}
