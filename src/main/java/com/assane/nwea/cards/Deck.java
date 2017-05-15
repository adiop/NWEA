package com.assane.nwea.cards;

import com.assane.nwea.entities.Player;

import java.util.List;

/**
 * Created by u2346 on 05/13/17.
 * A Deck is a collection of cards
 */
public interface Deck  {

    public List<Card> getDeckOfCards();

    public void shuffleDeckOfCards();

    public void dealDeckOfCards (List<Player> playerList);
}
