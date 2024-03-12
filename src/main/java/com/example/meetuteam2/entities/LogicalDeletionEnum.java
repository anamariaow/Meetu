package com.example.meetuteam2.entities;

public enum LogicalDeletionEnum {
    ATTIVO("attivato","1"),
    DISATTIVATO("disattivato","0");

    private String descrizione;
    private String value;

    LogicalDeletionEnum(String descrizione,String value) {
        this.descrizione = descrizione;
        this.value = value;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getValue() {
        return value;
    }
}
