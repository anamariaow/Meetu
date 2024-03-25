package com.example.meetuteam2.entities.enums;

public enum InterestEnum {
    BOOKS("Reading"),
    SPORT("Sport"),
    YOGA("Yoga"),
    ART("Art"),
    DANCE("Dance"),
    PHOTOGRAPHY("Photography"),
    MUSIC("Music"),
    ACTIVISM("Activism"),
    GARDENING("Gardening"),
    VIDEOGAMES("Videogames"),
    BOARD_GAMES("Board games"),
    WRITING("Writing"),
    SCRAPBOOKING("Scrapbooking"),
    SINGING("Singing"),
    INSTRUMENTS("Instruments"),
    ANIMAL("Animals"),
    CYCLING("Cycling"),
    MOTORSPORTS("Motor sports"),
    WATERSPORTS("Water sports"),
    ANIMALS("Animals"),
    CLIMBING("Climbing"),
    SAILING("Sailing"),
    MARTIAL_ARTS("Martial arts"),
    COLLECTING("Collecting"),
    WAR_SIMULATION_SPORTS("War simulation sports"),
    FISHING("Fishing"),
    TENNIS("Tennis"),
    FOOTBALL("Football"),
    BASKETBALL("Basket ball"),
    VOLLEYBALL("Volleyball"),
    ASTROLOGY("Astrology"),
    ASTRONOMY("Astronomy"),
    TRAVEL("Travel"),
    OTHER("Other");
    private String description;

    InterestEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
