package com.example.david.selectcard.managers;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.david.selectcard.model.Card;
import com.example.david.selectcard.model.Deck;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.io.StringReader;

public class CardApiManager {

    public interface CardApiManagerNewCardListener {
        public void onNewCard(Card card);
    }

    private CardApiManagerNewCardListener listener;

    public void setOnNewCardListener(CardApiManagerNewCardListener listener) {
        this.listener = listener;
    }

    private static final String INICIO = "https://deckofcardsapi.com/api/deck/";
    private static final String FIN = "/draw/?count=1";


    public void newCard(Context context, Deck deck){

        String URL=INICIO+deck.getId()+FIN;
        //  Log.d("error bug", deck.getId());

        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {       // si funciona
            @Override
            public void onResponse(String response) {
                Log.d("RESPONSE", response);
                parseJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {                                                // si no funciona
                Log.e("HORROR", "Connection went to shit to the tracks");

            }
        });

        queue.add(request);
    }
    private void parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        Reader reader = new StringReader(response);

        CardEntity cardEntity = gson.fromJson(reader , CardEntity.class);

        Card card = new Card();
        card.setImage(cardEntity.getCards().get(0).getImagecard());
        card.setRemainingCard(cardEntity.getRemaining());

        if (listener!=null) {
            listener.onNewCard(card);
        }
    }
}
