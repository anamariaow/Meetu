package com.example.meetuteam2.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "record_status", nullable = false, length = 1)
    private RecordStatusEnum recordStatus;

    public Review(Long id, Double grade, String text, LocalDate dateOfReview, RecordStatusEnum recordStatus, User user) {
        this.id = id;
        this.grade = grade;
        this.text = text;
        this.dateOfReview = dateOfReview;
        this.recordStatus = recordStatus;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RecordStatusEnum getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(RecordStatusEnum recordStatus) {
        this.recordStatus = recordStatus;
    }
}
