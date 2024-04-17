package com.example.meetuteam2.entities;

import com.example.meetuteam2.entities.enums.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
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

    @Column
    private String profilePicture;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String moreInfo;
    @ElementCollection(targetClass = OrientationEnum.class)
    @NotNull
    @Column(nullable = false)
    private List<InterestEnum> interestEnumList;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private GenderEnum genderEnum;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "zodiac_sign", nullable = false)
    private ZodiacSignEnum zodiacSignEnum;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "orientation_list", nullable = false)
    private OrientationEnum orientationEnum;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "user_experience", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "experience_id"))
    private List<Experience> experienceList = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Review> reviewList = new ArrayList<>();
    @JsonIgnore
    @OneToOne
    private Meets meets;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Booking> bookingList = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "record_status", nullable = false, length = 1)
    private RecordStatusEnum recordStatus;


    public User(Long id, String name, String email, String password, String profilePicture, String moreInfo, List<InterestEnum> interestEnumList,
                GenderEnum genderEnum, ZodiacSignEnum zodiacSignEnum, OrientationEnum orientationEnum,
                List<Experience> experienceList, List<Review> reviewList, Meets meets, List<Booking> bookingList,
                RecordStatusEnum recordStatus) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profilePicture = profilePicture;
        this.moreInfo = moreInfo;
        this.interestEnumList = interestEnumList;
        this.genderEnum = genderEnum;
        this.zodiacSignEnum = zodiacSignEnum;
        this.orientationEnum = orientationEnum;
        this.experienceList = experienceList;
        this.reviewList = reviewList;
        this.meets = meets;
        this.bookingList = bookingList;
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

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public List<InterestEnum> getInterestEnumList() {
        return interestEnumList;
    }

    public void setInterestEnumList(List<InterestEnum> interestEnumList) {
        this.interestEnumList = interestEnumList;
    }

    public GenderEnum getGenderEnum() {
        return genderEnum;
    }

    public void setGenderEnum(GenderEnum genderEnum) {
        this.genderEnum = genderEnum;
    }

    public ZodiacSignEnum getZodiacSignEnum() {
        return zodiacSignEnum;
    }

    public void setZodiacSignEnum(ZodiacSignEnum zodiacSignEnum) {
        this.zodiacSignEnum = zodiacSignEnum;
    }

    public OrientationEnum getOrientationEnum() {
        return orientationEnum;
    }

    public void setOrientationEnum(OrientationEnum orientationEnum) {
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