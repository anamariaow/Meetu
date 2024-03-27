package com.example.meetuteam2.repositories;

import com.example.meetuteam2.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Query("SELECT r FROM Review r WHERE recordStatus = 'A'")
    List<Review> findAllActiveReview();
    @Query("SELECT r FROM Review r WHERE recordStatus = 'A' AND id = ?1")
    Optional<Review> findActiveReviewById(Long id);
}
