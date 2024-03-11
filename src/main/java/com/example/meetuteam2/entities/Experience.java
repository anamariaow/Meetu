package com.example.meetuteam2.entities;

import jakarta.persistence.*;

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
    private LogicalDeletionEnum recordStatus;

    public Experience(Long id, String name, String description, Double price, String typeExperience, Integer experienceValue,
                      Integer idUserFK, LogicalDeletionEnum recordStatus) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.typeExperience = typeExperience;
        this.experienceValue = experienceValue;
        this.idUserFK = idUserFK;
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

    public LogicalDeletionEnum getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(LogicalDeletionEnum recordStatus) {
        this.recordStatus = recordStatus;
    }
}
