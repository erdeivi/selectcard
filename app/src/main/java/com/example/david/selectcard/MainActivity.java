package com.example.david.selectcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.selectcard.managers.CardApiManager;
import com.example.david.selectcard.managers.DeckApiManager;
import com.example.david.selectcard.model.Card;
import com.example.david.selectcard.model.Deck;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView cardImage;
    private Deck deck;
    private TextView numberOfCardsInCardInDeck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardImage = (ImageView) findViewById(R.id.activity_main___card_image);
        numberOfCardsInCardInDeck = (TextView) findViewById(R.id.activity_main___cards_left_text);



        DeckApiManager apiManager = new DeckApiManager();
        apiManager.setOnNewDeckListener(new DeckApiManager.DeckApiManagerNewDeckListener() {
            @Override
            public void onNewDeck(Deck deckJson) {
                numberOfCardsInCardInDeck.setText(""+deckJson.getRemaining());
                deck = deckJson;

            }
        });

        apiManager.newDeck(this);

        cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                CardApiManager apiManager = new CardApiManager();
                apiManager.setOnNewCardListener(new CardApiManager.CardApiManagerNewCardListener() {
                    @Override
                    public void onNewCard(Card card) {
                        Picasso.with(view.getContext()).load(card.getImage()).into(cardImage);
                        numberOfCardsInCardInDeck.setText(""+card.getRemainingCard());

                    }
                });

                apiManager.newCard(view.getContext(),deck);
            }
        });

    }
}

