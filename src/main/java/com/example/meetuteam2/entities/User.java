package com.example.meetuteam2.entities;

import jakarta.persistence.*;

import java.util.List;
@Table
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String moreInfo;

    @Column(nullable = true)
    private String interestList;

    @Column(nullable = false)
    private String genderEnum;

    @Column(nullable = true)
    private String zodiacSignEnum;

    @Column(nullable = true)
    private String orientationEnum;

     @ManyToMany(fetch = FetchType.LAZY)
     private List<Experience> experience;
    public User(Long id, String name, String email, String password, String moreInfo, String interestList, String genderEnum, String zodiacSignEnum, String orientationEnum) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.moreInfo = moreInfo;
        this.interestList = interestList;
        this.genderEnum = genderEnum;
        this.zodiacSignEnum = zodiacSignEnum;
        this.orientationEnum = orientationEnum;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getInterestList() {
        return interestList;
    }

    public void setInterestList(String interestList) {
        this.interestList = interestList;
    }

    public String getGenderEnum() {
        return genderEnum;
    }

    public void setGenderEnum(String genderEnum) {
        this.genderEnum = genderEnum;
    }

    public String getZodiacSignEnum() {
        return zodiacSignEnum;
    }

    public void setZodiacSignEnum(String zodiacSignEnum) {
        this.zodiacSignEnum = zodiacSignEnum;
    }

    public String getOrientationEnum() {
        return orientationEnum;
    }

    public void setOrientationEnum(String orientationEnum) {
        this.orientationEnum = orientationEnum;
    }
}
