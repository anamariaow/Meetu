package com.example.meetuteam2.controllers;

import com.example.meetuteam2.entities.Review;
import com.example.meetuteam2.entities.enums.RecordStatusEnum;
import com.example.meetuteam2.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/createreview")
    public ResponseEntity<Review> createMeets(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.createReview(review));
    }

    @GetMapping("/getreview")
    public ResponseEntity<List<Review>> findAllReview() {
        return ResponseEntity.ok(reviewService.getActiveReviewList());
    }

    @GetMapping("/findreview/{id}")
    public ResponseEntity<Optional<Review>> findByIdReview(@RequestParam Long id) {
        Optional<Review> reviewOptional = reviewService.getReviewById(id);
        if (reviewOptional.isPresent()) {
            return ResponseEntity.ok(reviewOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updatereview")
    public ResponseEntity<Review> modifyMeets(@PathVariable Long id, @RequestBody Review review) {
        Optional<Review> reviewOptional = reviewService.updateReview(id, review);
        if (reviewOptional.isPresent()) {
            return ResponseEntity.ok(reviewOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/deletereview")
    public ResponseEntity<Review> deleteMeetsStatus(@PathVariable Long id) {
        Optional<Review> reviewOptional = reviewService.deleteReviewRecordStatus(id);
        if (reviewOptional.isPresent()) {
            return ResponseEntity.ok(reviewOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
