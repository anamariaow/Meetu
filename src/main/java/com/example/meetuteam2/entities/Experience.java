package com.example.meetuteam2.entities;

import com.example.meetuteam2.entities.enums.ExperienceEnum;
import com.example.meetuteam2.entities.enums.OrientationEnum;
import com.example.meetuteam2.entities.enums.RecordStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

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
    @ManyToMany(mappedBy = "experienceList")
    private List<User> user;
    @JsonIgnore
    @OneToMany(mappedBy = "experience")
    private List<Booking> booking;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "record_status", nullable = false, length = 1)
    private RecordStatusEnum recordStatus;

    public Experience(Long id, String name, String description, Double price, List<ExperienceEnum> typeExperienceEnumList, Integer experienceValue,
                       RecordStatusEnum recordStatus, List<User> user, List<Booking> booking) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.typeExperienceEnumList = typeExperienceEnumList;
        this.experienceValue = experienceValue;
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

    public List<ExperienceEnum> getTypeExperienceEnumList() {
        return typeExperienceEnumList;
    }

    public void setTypeExperienceEnumList(List<ExperienceEnum> typeExperience) {
        this.typeExperienceEnumList = typeExperience;
    }

    public Integer getExperienceValue() {
        return experienceValue;
    }

    public void setExperienceValue(Integer experienceValue) {
        this.experienceValue = experienceValue;
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
