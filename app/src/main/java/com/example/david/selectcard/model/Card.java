package com.example.david.selectcard.model;

public class Card {
    public enum Suit{                                                                               //enumeramos los palos de la baraja
        SPADES,
        HEARTS,
        DIAMONDS,
        CLUBS
    }

    private Suit suit;                                                                              //baraja
    private String image;                                                                           //foto de la carta

    private int remainingCard;

    public int getRemainingCard() {
        return remainingCard;
    }

    public void setRemainingCard(int remainingCard) {
        this.remainingCard = remainingCard;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}