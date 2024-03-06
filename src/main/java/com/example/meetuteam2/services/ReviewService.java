package com.example.meetuteam2.services;

import com.example.meetuteam2.entities.Review;
import com.example.meetuteam2.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review createReview(Review review){
        reviewRepository.save(review);
        return review;
    }
    public List<Review> reviewsList(){
        List<Review> reviewList = reviewRepository.findAll();
        return reviewList;
    }
}
