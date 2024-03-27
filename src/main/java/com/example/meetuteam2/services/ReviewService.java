package com.example.meetuteam2.services;

import com.example.meetuteam2.entities.Review;
import com.example.meetuteam2.entities.enums.RecordStatusEnum;
import com.example.meetuteam2.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review createReview(Review review){
        Review savedReview = reviewRepository.save(review);
        return savedReview;
    }
    public List<Review> getActiveReviewList(){
        List<Review> reviewsList = reviewRepository.findAllActiveReview();
        return reviewsList;
    }
    public Optional<Review> getReviewById(Long id){
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isPresent()){
            return reviewOptional;
        }else {
            return Optional.empty();
        }
    }
    public Optional<Review> updateReview(Long id,Review review){
        Optional<Review> reviewOptional = getReviewById(id);
        if(reviewOptional.isPresent()){
            reviewOptional.get().setGrade(review.getGrade());
            reviewOptional.get().setText(review.getText());
            reviewOptional.get().setDateOfReview(review.getDateOfReview());
            reviewOptional.get().setUser(review.getUser());
            reviewOptional.get().setRecordStatus(review.getRecordStatus());
            Review savedReview = reviewRepository.save(reviewOptional.get());
            return Optional.of(savedReview);
        }else {
            return Optional.empty();
        }
    }
    public Optional<Review> updateReviewRecordStatus(Long id, RecordStatusEnum recordStatusEnum){
        Optional<Review> reviewOptional = getReviewById(id);
        if(reviewOptional.isPresent()){
            reviewOptional.get().setRecordStatus(recordStatusEnum);
            Review savedReview = reviewRepository.save(reviewOptional.get());
            return Optional.of(savedReview);
        }else {
            return Optional.empty();
        }
    }
    public Optional<Review> deleteReview(Long id){
        Optional<Review> reviewOptional = getReviewById(id);
        if(reviewOptional.isPresent()){
            reviewRepository.deleteById(reviewOptional.get().getId());
            return Optional.of(reviewOptional.get());
        }else {
            return Optional.empty();
        }
    }

}
