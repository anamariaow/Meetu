package com.example.meetuteam2.entities;

import jakarta.persistence.*;
@Table
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column (nullable = false)
    private String typeExperience;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    public Booking(long id, String name, String description, Double price, String typeExperience) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.typeExperience = typeExperience;
    }

    public Booking() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTypeExperience() {
        return typeExperience;
    }

    public void setTypeExperience(String typeExperience) {
        this.typeExperience = typeExperience;
    }
}
