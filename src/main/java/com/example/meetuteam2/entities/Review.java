package com.example.meetuteam2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Double grade;
    @Column
    private String text;
    @Column
    private LocalDate dateOfReview;
    @Column(nullable = false)
    private LogicalDeletionEnum recordStatus;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Review(Long id, Double grade, String text, LocalDate dateOfReview, LogicalDeletionEnum recordStatus) {
        this.id = id;
        this.grade = grade;
        this.text = text;
        this.dateOfReview = dateOfReview;
        this.recordStatus = recordStatus;
    }

    public Review() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDateOfReview() {
        return dateOfReview;
    }

    public void setDateOfReview(LocalDate dateOfReview) {
        this.dateOfReview = dateOfReview;
    }

    public LogicalDeletionEnum getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(LogicalDeletionEnum recordStatus) {
        this.recordStatus = recordStatus;
    }
}
