package com.assane.nwea.entities;

import com.assane.nwea.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by u2346 on 05/13/17.
 */
public class Player {
    public String _name;
    public List<Card> result = null;
    public List<Card> hand = null;

    public Player(String name) {
        _name = name;
    }

    public String get_name() {
        return _name;
    }

    public void receiveCard (Card card){
        if (hand == null ) {
            hand = new ArrayList<>();
            hand.add(card);
        } else {
            hand.add(card);
        }
    }

    public int getHandSize() {
        if (hand == null)
            return 0;
        else
            return hand.size();
    }

    public void printHand() {
        if (hand != null) {
            hand.forEach(item -> {
                System.out.println(item.toString());
            });
            System.out.println("DONE");
        }
    }

    public Card pickTopCardInHand() {
        if (hand != null && hand.size() > 0) {
            return hand.get(getHandSize() -1);
        }
        return null;
    }

    public void resultHand (Card card) {
        if (result == null) {
            result = new ArrayList<>();
            result.add(card);
        } else {
            result.add(card);
        }
    }

    public void removeCardFromHand () {
        if (hand.size() > 0)
            hand.remove(getHandSize() -1);
    }

    public int getCardResultSize () {
        if (result == null) {
            return 0;
        } else {
            return result.size();
        }
    }
}
