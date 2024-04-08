package com.example.meetuteam2.DTO;

import java.time.LocalDate;

public class ReviewDTO {
    private Long id;
    private Double grade;
    private String text;
    private LocalDate dateOfReview;

    public ReviewDTO(LocalDate dateOfReview, Double grade, Long id, String text) {
        this.dateOfReview = dateOfReview;
        this.grade = grade;
        this.id = id;
        this.text = text;
    }

    public ReviewDTO() {
    }

    public LocalDate getDateOfReview() {
        return dateOfReview;
    }

    public void setDateOfReview(LocalDate dateOfReview) {
        this.dateOfReview = dateOfReview;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
