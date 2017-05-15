package com.assane.nwea.deckFormat;

import com.assane.nwea.cards.Card;
import com.assane.nwea.cards.CardDeck;

import java.util.ArrayList;

/**
 * Created by u2346 on 05/13/17.
 */
public class SpanishSuitsDeck extends CardDeck {
    public SpanishSuitsDeck () {
        deck = new ArrayList<>();
        for (Card.Rank rank : Card.Rank.values()) {
            for (Card.SpanishSuit suit : Card.SpanishSuit.values()) {
                if (!suit.toString().equalsIgnoreCase("Joker")) {
                    Card card = new Card(suit.toString(), rank.toString());
                    deck.add(card);
                }
            }
        }

    }
}
