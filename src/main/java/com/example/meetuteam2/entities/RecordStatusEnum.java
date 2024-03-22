package com.example.meetuteam2.entities;

public enum RecordStatusEnum {
    A("This record is active"),
    I("This record is inactive"),
    D("This record is deleted");
    private String description;

    RecordStatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
