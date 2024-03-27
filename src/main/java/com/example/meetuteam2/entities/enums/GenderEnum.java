package com.example.meetuteam2.entities.enums;

public enum GenderEnum {
    MALE ("Male"),
    FEMALE ("Female"),
    GENDER_FLUID("Gender fluid"),
    PANDGENDER("Pangender"),
    INTERSEX("Intersex"),
    TRANS_WOMAN("Trans woman"),
    TRANS_MAN("Trans man"),
    QUESTIONING("Questioning"),
    OTHER("Other"),
    NON_BINARY ("Non binary");
    private String description;

    GenderEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
