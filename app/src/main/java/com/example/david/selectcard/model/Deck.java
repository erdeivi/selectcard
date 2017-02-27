package com.example.david.selectcard.model;

public class Deck {
    public Deck() {
    }

    private int remaining;
    private String id;

    public Deck(int remaining) {
        this.remaining = remaining;
    }

    public Deck(String id) {                //esto no funcionaria con REALM, no tiene contructor por defecto, ahora lo hemos metido, ahora si va
        this.id = id;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}