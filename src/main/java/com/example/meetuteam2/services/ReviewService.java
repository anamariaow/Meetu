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
    /**
     * questo metodo crea una nuova Review
     * @param review
     * @return Review inserito
     * @author AT
     */
    public Review createReview(Review review){
        Review savedReview = reviewRepository.save(review);
        return savedReview;
    }
    /**
     * questo metodo ritorna la lista delle Review attive
     * @return lista delle Review attive
     * @author AT
     */
    public List<Review> getActiveReviewList(){
        List<Review> reviewsList = reviewRepository.findAllActiveReview();
        return reviewsList;
    }
    /**
     * questo metodo recupera una Review partendo dal suo id
     * @param id
     * @return la Review trovata (se presente) oppure ritorna un Optional vuoto
     * @author AT
     */
    public Optional<Review> getReviewById(Long id){
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isPresent()){
            return reviewOptional;
        }else {
            return Optional.empty();
        }
    }
    /**
     * questo metodo aggiorna i field selezionati di un User, recuperandolo attraverso l'id
     * @param id
     * @param review
     * @return la Review aggiornata (se presente) oppure ritorna un Optional vuoto
     * @author AT
     */
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
    /**
     * questo metodo aggiorna lo status di una Review in deleted, recuperandolo attraverso l'id
     * @param id
     * @return la Review aggiornata (se presente) oppure ritorna un Optional vuoto
     * @author AT
     */
    public Optional<Review> deleteReviewRecordStatus(Long id){
        Optional<Review> reviewOptional = getReviewById(id);
        if(reviewOptional.isPresent()){
            reviewOptional.get().setRecordStatus(RecordStatusEnum.D);
            Review savedReview = reviewRepository.save(reviewOptional.get());
            return Optional.of(savedReview);
        }else {
            return Optional.empty();
        }
    }

}
