package com.example.david.selectcard.managers;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CardEntity {
    @SerializedName("remaining") private int remaining;
    @SerializedName("cardId") private String cardId;
    @SerializedName("success") private boolean success;

    public List<GsonCard> getCards() {
        return cards;
    }

    public void setCards(List<GsonCard> cards) {
        this.cards = cards;
    }

    @SerializedName("cards") private List<GsonCard> cards; //cambiado de shuffled


    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String deckId) {
        this.cardId = cardId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }




    public class GsonCard{
        public String getImagecard() {
            return imagecard;
        }

        public void setImagecard(String imagecard) {
            this.imagecard = imagecard;
        }

        @SerializedName("image") private String imagecard;

    }
}
