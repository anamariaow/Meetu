package com.example.meetuteam2.controllers;

import com.example.meetuteam2.DTO.ReviewDTO;
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

    @PostMapping("/createreview/{userId}")
    public ResponseEntity<ReviewDTO> createReview(@PathVariable(name = "userId") Long userId,
                                                  @RequestParam Long experienceId,@RequestBody ReviewDTO reviewDTO) {
        Optional<ReviewDTO> reviewResponseOptional  = reviewService.createReview(userId,experienceId,reviewDTO);
        if(reviewResponseOptional.isPresent()) {
            return ResponseEntity.ok().body(reviewResponseOptional.get());
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getreviews")
    public ResponseEntity<List<ReviewDTO>> findAllReview() {
        return ResponseEntity.ok(reviewService.getActiveReviewList());
    }

    @GetMapping("/findreview/{id}")
    public ResponseEntity<ReviewDTO> findByIdReview(@RequestParam Long id) {
        Optional<ReviewDTO> reviewOptional = reviewService.getReviewById(id);
        if (reviewOptional.isPresent()) {
            return ResponseEntity.ok(reviewOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updatereview/{id}")
    public ResponseEntity<ReviewDTO> modifyReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
        Optional<ReviewDTO> reviewOptional = reviewService.updateReview(id, reviewDTO);
        if (reviewOptional.isPresent()) {
            return ResponseEntity.ok(reviewOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/deletereview/{id}")
    public ResponseEntity<ReviewDTO> deleteReviewStatus(@PathVariable Long id) {
        Optional<ReviewDTO> reviewOptional = reviewService.deleteReviewRecordStatus(id);
        if (reviewOptional.isPresent()) {
            return ResponseEntity.ok(reviewOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
