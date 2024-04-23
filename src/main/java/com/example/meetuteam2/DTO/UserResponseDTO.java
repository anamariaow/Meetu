package com.example.meetuteam2.DTO;

import com.example.meetuteam2.entities.enums.GenderEnum;
import com.example.meetuteam2.entities.enums.InterestEnum;
import com.example.meetuteam2.entities.enums.OrientationEnum;
import com.example.meetuteam2.entities.enums.ZodiacSignEnum;

import java.util.List;

public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String moreInfo;
    private List<InterestEnum> interestEnumList;
    private GenderEnum genderEnum;
    private ZodiacSignEnum zodiacSignEnum;
    private OrientationEnum orientationEnum;

    public UserResponseDTO(Long id, String name, String email,
                           String moreInfo, List<InterestEnum> interestEnumList,
                           GenderEnum genderEnum, ZodiacSignEnum zodiacSignEnum,
                           OrientationEnum orientationEnum) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.moreInfo = moreInfo;
        this.interestEnumList = interestEnumList;
        this.genderEnum = genderEnum;
        this.zodiacSignEnum = zodiacSignEnum;
        this.orientationEnum = orientationEnum;
    }

    public UserResponseDTO() {
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
}
