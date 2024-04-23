package com.example.meetuteam2.controllers;

import com.example.meetuteam2.DTO.ReviewDTO;
import com.example.meetuteam2.services.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Review", description = "Controller delle APIs per Review")
@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Operation(summary = "Crea e salva una nuova review")
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

    @Operation(summary = "Mostra una lista di tutte le review")
    @GetMapping("/getreviews")
    public ResponseEntity<List<ReviewDTO>> findAllReview() {
        return ResponseEntity.ok(reviewService.getActiveReviewList());
    }

    @Operation(summary = "Trova una review tramite l'id")
    @GetMapping("/findreview/{id}")
    public ResponseEntity<ReviewDTO> findByIdReview(@RequestParam Long id) {
        Optional<ReviewDTO> reviewOptional = reviewService.getReviewById(id);
        if (reviewOptional.isPresent()) {
            return ResponseEntity.ok(reviewOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Aggiorna una review tramite l'id")
    @PutMapping("/updatereview/{id}")
    public ResponseEntity<ReviewDTO> modifyReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
        Optional<ReviewDTO> reviewOptional = reviewService.updateReview(id, reviewDTO);
        if (reviewOptional.isPresent()) {
            return ResponseEntity.ok(reviewOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Elimina una review")
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
