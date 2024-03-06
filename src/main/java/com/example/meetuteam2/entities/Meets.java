package com.example.meetuteam2.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Meets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private LocalDateTime releaseDate;

//    @OneToOne(fetch = FetchType.LAZY)
//    private User user;


    public Meets(Long id, Integer quantity, LocalDateTime releaseDate) {
        this.id = id;
        this.quantity = quantity;
        this.releaseDate = releaseDate;
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
}
