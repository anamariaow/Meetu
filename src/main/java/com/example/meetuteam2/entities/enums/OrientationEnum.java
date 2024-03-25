package com.example.meetuteam2.entities.enums;

public enum OrientationEnum {
    STRAIGHT("Straight"),
    LESBIAN("Lesbian"),
    DEMISEXUAL("Deminsexual"),
    PANSEXUAL("Pansexual"),
    ASEXUAL("Asexal"),
    QUESTIONING("Questioning"),
    OTHER("Other"),
    QUEER("Queer"),
    BISEXUAL("Bisexual"),
    GAY("Gay");

    private String description;
    OrientationEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
