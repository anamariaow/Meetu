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

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    private LogicalDeletionEnum meetsDeletion;

    public Meets(Long id, Integer quantity, LocalDateTime releaseDate, User user, LogicalDeletionEnum meetsDeletion) {
        this.id = id;
        this.quantity = quantity;
        this.releaseDate = releaseDate;
        this.user = user;
        this.meetsDeletion = meetsDeletion;
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

    public LogicalDeletionEnum getMeetsDeletion() {
        return meetsDeletion;
    }

    public void setMeetsDeletion(LogicalDeletionEnum meetsDeletion) {
        this.meetsDeletion = meetsDeletion;
    }
}
