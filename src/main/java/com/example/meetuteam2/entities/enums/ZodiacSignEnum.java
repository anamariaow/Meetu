package com.example.meetuteam2.entities.enums;

public enum ZodiacSignEnum {
    ARIES("Aries"),
    TAURUS("Taurus"),
    GEMINI("Gemini"),
    CANCER("Cancer"),
    LEO("Leo"),
    VIRGO("Virgo"),
    LIBRA("Libra"),
    SCORPIO("Scorpio"),
    SAGITTARIUS("Sagittarius"),
    CAPRICORN("Capricorn"),
    AQUARIUS("Aquarius"),
    PISCES("Pisces"),
    BLANK("Blank");
    private String description;

    ZodiacSignEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
