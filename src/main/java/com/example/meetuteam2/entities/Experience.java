package com.example.meetuteam2.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String typeExperience;

    @Column(nullable = false)
    private Integer experienceValue;

    @Column(nullable = false)
    private Integer idUserFK;

    @Column(nullable = false)
    private RecordStatusEnum recordStatus;

    @ManyToMany(mappedBy = "experienceList")
    private List<User> user;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Booking> booking;

    public Experience(Long id, String name, String description, Double price, String typeExperience, Integer experienceValue,
                      Integer idUserFK, RecordStatusEnum recordStatus, List<User> user, List<Booking> booking) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.typeExperience = typeExperience;
        this.experienceValue = experienceValue;
        this.idUserFK = idUserFK;
        this.recordStatus = recordStatus;
        this.user = user;
        this.booking = booking;
    }

    public Experience() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getExperienceValue() {
        return experienceValue;
    }

    public void setExperienceValue(Integer experienceValue) {
        this.experienceValue = experienceValue;
    }

    public Integer getIdUserFK() {
        return idUserFK;
    }

    public void setIdUserFK(Integer idUserFK) {
        this.idUserFK = idUserFK;
    }

    public RecordStatusEnum getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(RecordStatusEnum recordStatus) {
        this.recordStatus = recordStatus;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }
}
