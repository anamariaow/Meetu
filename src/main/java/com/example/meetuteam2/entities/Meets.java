package com.example.meetuteam2.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table
@Entity
public class Meets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private LocalDateTime releaseDate;

    @Column(nullable = false)
    private RecordStatusEnum recordStatus;

    public Meets(Long id, Integer quantity, LocalDateTime releaseDate, RecordStatusEnum recordStatus) {
        this.id = id;
        this.quantity = quantity;
        this.releaseDate = releaseDate;
        this.recordStatus = recordStatus;
    }

    public Meets() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public RecordStatusEnum getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(RecordStatusEnum recordStatus) {
        this.recordStatus = recordStatus;
    }
}
