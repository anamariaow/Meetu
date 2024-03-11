package com.example.meetuteam2.entities;

public enum LogicalDeletionEnum {
    ATTIVO("attivato"),
    DISATTIVATO("disattivato");

    private String descrizione;

    LogicalDeletionEnum(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
