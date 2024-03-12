package com.example.meetuteam2.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "user_meets")
    private User user;

    @Column(nullable = false)
    private LogicalDeletionEnum recordStatus;

    public Meets(Long id, Integer quantity, LocalDateTime releaseDate, User user, LogicalDeletionEnum recordStatus) {
        this.id = id;
        this.quantity = quantity;
        this.releaseDate = releaseDate;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LogicalDeletionEnum getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(LogicalDeletionEnum recordStatus) {
        this.recordStatus = recordStatus;
    }
}
