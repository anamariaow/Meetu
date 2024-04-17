package com.example.meetuteam2.entities;

import com.example.meetuteam2.entities.enums.ExperienceEnum;
import com.example.meetuteam2.entities.enums.OrientationEnum;
import com.example.meetuteam2.entities.enums.RecordStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
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
    @ElementCollection(targetClass = ExperienceEnum.class)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private List<ExperienceEnum> typeExperienceEnumList;

    @Column(nullable = false)
    private Integer experienceValue;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "user_experience", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "experience_id"))
    private List<User> user = new ArrayList<>();
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "user_booking", joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "experience_id"))
    private List<Booking> booking = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "record_status", nullable = false, length = 1)
    private RecordStatusEnum recordStatus;

    public Experience(Long id, String name, String description, Double price, List<ExperienceEnum> typeExperienceEnumList, Integer experienceValue, List<User> user, List<Booking> booking, RecordStatusEnum recordStatus) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.typeExperienceEnumList = typeExperienceEnumList;
        this.experienceValue = experienceValue;
        this.user = user;
        this.booking = booking;
        this.recordStatus = recordStatus;
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

    public List<ExperienceEnum> getTypeExperienceEnumList() {
        return typeExperienceEnumList;
    }

    public void setTypeExperienceEnumList(List<ExperienceEnum> typeExperienceEnumList) {
        this.typeExperienceEnumList = typeExperienceEnumList;
    }

    public Integer getExperienceValue() {
        return experienceValue;
    }

    public void setExperienceValue(Integer experienceValue) {
        this.experienceValue = experienceValue;
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

    public RecordStatusEnum getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(RecordStatusEnum recordStatus) {
        this.recordStatus = recordStatus;
    }
}

