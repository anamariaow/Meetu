package com.example.meetuteam2.controllers;

import com.example.meetuteam2.entities.Review;
import com.example.meetuteam2.services.ReviewService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/addreview")
    public ResponseEntity<Review> addReview(@RequestBody Review review){
        reviewService.createReview(review);
        return ResponseEntity.ok().body(review);
    }

    @GetMapping("/getreviews")
    public ResponseEntity<List<Review>> getReviews(){
        List<Review> reviewList = reviewService.reviewsList();
        return ResponseEntity.ok().body(reviewList);
    }

}
