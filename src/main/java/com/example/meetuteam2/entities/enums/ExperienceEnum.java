package com.example.meetuteam2.entities.enums;

import jakarta.persistence.Enumerated;

public enum ExperienceEnum {

    THEATER_CINEMA ("Theater & Cinema"),
    CONCERT_MUSIC ("Concert & Music"),
    FOOD_DRINK ("Food & Drink"),
    CLUB ("Club"),
    NIGHT_LIFE ("Night life"),
    ACADEMIC ("Academic"),
    SPORT ("Sport"),
    ROMANTIC ("Romantic"),
    EXHIBITION ("Exhibition"),
    LOCAL_FOLKLORE ("Local folklore"),
    NATURE ("Nature"),
    OTHER ("Other");
    private String description;

    ExperienceEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
