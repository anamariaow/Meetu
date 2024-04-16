package com.example.meetuteam2.services;

import com.example.meetuteam2.DTO.ReviewDTO;
import com.example.meetuteam2.entities.Review;
import com.example.meetuteam2.entities.User;
import com.example.meetuteam2.entities.enums.RecordStatusEnum;
import com.example.meetuteam2.repositories.ReviewRepository;
import com.example.meetuteam2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;
    /**
     * questo metodo richiede una ReviewDTO, la trasforma in Review Entity per poi salvarla.
     * crea e poi ritorna una ReviewDTO come response utilizzando i dati della Review Entity appena salvata,
     * @param reviewRequestDTO
     * @return la ReviewDTO creata
     * @author AT
     */
    public Optional<ReviewDTO> createReview(Long userId,ReviewDTO reviewRequestDTO){
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()) {
            Review review = new Review();
            review.setGrade(reviewRequestDTO.getGrade());
            review.setText(reviewRequestDTO.getText());
            review.setDateOfReview(LocalDate.now());
            review.setUser(userOptional.get());
            review.setRecordStatus(RecordStatusEnum.A);

            Review savedReview = reviewRepository.save(review);

            ReviewDTO reviewResponseDTO = new ReviewDTO();

            reviewResponseDTO.setId(savedReview.getId());
            reviewResponseDTO.setText(savedReview.getText());
            reviewResponseDTO.setGrade(savedReview.getGrade());
            reviewResponseDTO.setDateOfReview(savedReview.getDateOfReview());

            return Optional.of(reviewResponseDTO);
        }else {
            return Optional.empty();
        }
    }
    /**
     * questo metodo richiede la lista delle Review attive
     * crea una lista di ReviewDTO
     * cicla per inserire all'interno della lista le reviewDTO utilizzando gli oggetti presenti
     * nella lista di Review richiesta.
     * @return lista delle ReviewDTO attive
     * @author AT
     */
    public List<ReviewDTO> getActiveReviewList(){
        List<Review> reviewsList = reviewRepository.findAllActiveReview();
        List<ReviewDTO> reviewDTOList = new ArrayList<>();
        for(Review review : reviewsList){
            ReviewDTO reviewResponseDTO = new ReviewDTO();

            reviewResponseDTO.setId(review.getId());
            reviewResponseDTO.setText(review.getText());
            reviewResponseDTO.setGrade(review.getGrade());
            reviewResponseDTO.setDateOfReview(review.getDateOfReview());

            reviewDTOList.add(reviewResponseDTO);
        }
        return reviewDTOList;
    }
    /**
     * questo metodo recupera una Review partendo dal suo id, se presente
     * crea e ritorna una Review DTO e gli assegna i parametri della Review recuperata.
     * @param id
     * @return la ReviewDTO con i dati della Review recuperata
     * @author AT
     */
    public Optional<ReviewDTO> getReviewById(Long id){
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isPresent()){
            ReviewDTO reviewResponseDTO = new ReviewDTO();

            reviewResponseDTO.setId(reviewOptional.get().getId());
            reviewResponseDTO.setText(reviewOptional.get().getText());
            reviewResponseDTO.setGrade(reviewOptional.get().getGrade());
            reviewResponseDTO.setDateOfReview(reviewOptional.get().getDateOfReview());

            return Optional.of(reviewResponseDTO);
        }else {
            return Optional.empty();
        }
    }
    /**
     * questo metodo aggiorna i field selezionati di una Review, recuperandolo attraverso l'id
     * crea e ritorna una ReviewDTO con i dati della Review aggiornata
     * @param id
     * @param reviewDTO
     * @return la ReviewDTO aggiornata (se presente) oppure ritorna un Optional vuoto
     * @author AT
     */
    public Optional<ReviewDTO> updateReview(Long id,ReviewDTO reviewDTO){
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isPresent()){
            reviewOptional.get().setGrade(reviewDTO.getGrade());
            reviewOptional.get().setText(reviewDTO.getText());
            reviewOptional.get().setDateOfReview(reviewDTO.getDateOfReview());

            Review savedReview = reviewRepository.save(reviewOptional.get());

            ReviewDTO reviewResponseDTO = new ReviewDTO();

            reviewResponseDTO.setId(savedReview.getId());
            reviewResponseDTO.setText(savedReview.getText());
            reviewResponseDTO.setGrade(savedReview.getGrade());
            reviewResponseDTO.setDateOfReview(savedReview.getDateOfReview());

            return Optional.of(reviewResponseDTO);
        }else {
            return Optional.empty();
        }
    }
    /**
     * questo metodo aggiorna lo status di una Review in deleted, recuperandolo attraverso l'id
     * crea e ritorna una ReviewDTO con i medesimi dati della Review aggiornata
     * @param id
     * @return la ReviewDTO aggiornata (se presente) oppure ritorna un Optional vuoto
     * @author AT
     */
    public Optional<ReviewDTO> deleteReviewRecordStatus(Long id){
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isPresent()){
            reviewOptional.get().setRecordStatus(RecordStatusEnum.D);

            Review savedReview = reviewRepository.save(reviewOptional.get());

            ReviewDTO reviewResponseDTO = new ReviewDTO();

            reviewResponseDTO.setId(savedReview.getId());
            reviewResponseDTO.setText(savedReview.getText());
            reviewResponseDTO.setGrade(savedReview.getGrade());
            reviewResponseDTO.setDateOfReview(savedReview.getDateOfReview());

            return Optional.of(reviewResponseDTO);
        }else {
            return Optional.empty();
        }
    }

}
