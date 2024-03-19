package com.example.meetuteam2.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

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
    @JoinTable(name = "user_experience", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "experience_id"))
    private List<Experience> experienceList;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Review> reviewList;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "user_meets")
    private Meets meets;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Booking> bookingList;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "record_status", nullable = false, length = 1)
    private RecordStatusEnum recordStatus;

    public User(Long id, String name, String email, String password, String moreInfo, String interestList, String genderEnum,
                String zodiacSignEnum, String orientationEnum, List<Experience> experienceList, List<Review> reviewList, Meets meets,
                List<Booking> booking, RecordStatusEnum recordStatus) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.moreInfo = moreInfo;
        this.interestList = interestList;
        this.genderEnum = genderEnum;
        this.zodiacSignEnum = zodiacSignEnum;
        this.orientationEnum = orientationEnum;
        this.experienceList = experienceList;
        this.reviewList = reviewList;
        this.meets = meets;
        this.bookingList = booking;
        this.recordStatus = recordStatus;
    }

    public User() {
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

    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public Meets getMeets() {
        return meets;
    }

    public void setMeets(Meets meets) {
        this.meets = meets;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public RecordStatusEnum getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(RecordStatusEnum recordStatus) {
        this.recordStatus = recordStatus;
    }
}
