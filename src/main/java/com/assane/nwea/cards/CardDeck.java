package com.assane.nwea.cards;

import com.assane.nwea.entities.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by u2346 on 05/13/17.
 */
public class CardDeck implements Deck {
    public List<Card> deck;
    @Override
    public List<Card> getDeckOfCards() {

        return deck;
    }

    @Override
    public void shuffleDeckOfCards() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    @Override
    public void dealDeckOfCards(List<Player> playerList) {
        //int counter = 0;
        //for (Card card : deck) {
        System.out.println("The deck is of size " + deck.size());
        int numberOfCards = deck.size();
        int numberOfPlayers = playerList.size();
        int count = 0;

        List<List<Card>> chunkList = getChunkList(deck,numberOfCards/numberOfPlayers);
        int counter = 0;
        for (Player player : playerList) {
            List<Card> sublist = chunkList.get(count++);

            for (Card card : sublist) {
                player.receiveCard(card);
            }

            for (Card card : player.hand){
                card.toString();
            }
        }


    }

    private <T> List<List<T>> getChunkList(List<T> largeList , int chunkSize) {
        List<List<T>> chunkList = new ArrayList<>();
        for (int i = 0 ; i <  largeList.size() ; i += chunkSize) {
            chunkList.add(largeList.subList(i , i + chunkSize >= largeList.size() ? largeList.size() : i + chunkSize));
        }
        return chunkList;
    }


}
