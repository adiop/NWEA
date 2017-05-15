package com.assane.nwea;

import com.assane.nwea.Exceptions.WarGameException;
import com.assane.nwea.cards.Card;
import com.assane.nwea.deckFormat.FrenchSuitsDeck;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by u2346 on 05/15/17.
 */
public class WarTest {
    List<Card> deck = null;
    War war = new War();

    @Before
    public void setUp() throws Exception {
        FrenchSuitsDeck frenchSuitsDeck = new FrenchSuitsDeck();
        deck = frenchSuitsDeck.getDeckOfCards();
    }

    @After
    public void tearDown() throws Exception {
        deck = null;
    }

    @Test
    public void play() throws Exception {
    }

    @Test
    public void warGameRounds() throws Exception {
    }

    @Test
    public void doWeHaveAWinnerNullTest() throws Exception {
        try {
            war.doWeHaveAWinner(null);
        } catch (WarGameException ex) {
            assertEquals(ex.getMessage(), "The list of player in doWeHaveAWinner is null!!");
        }
    }

    @Test
    public void getCardsFromRoundNullTest() throws Exception {
        try {
            war.getCardsFromRound(null);
        } catch (WarGameException ex) {
            assertEquals(ex.getMessage(),"The key value pair representing the cards in the round was null!!");
        }
    }

    @Test
    public void sortListOfCardsNullTest() throws Exception {
        try {
            war.sortListOfCards(null);
        } catch (WarGameException warGame) {
            assertEquals(warGame.getMessage(),"The list in the sortListOfCards was null");
        }
    }

    @Test
    public void getWinningCardFromPotNullTest() throws Exception {
        try {
            war.getWinningCardFromPot(null);
        } catch (WarGameException warGame) {
            assertEquals(warGame.getMessage(),"The list in the getWinningCardFromPot was null");
        }
    }

    @Test
    public void getWinningPlayerFromThisRoundAllInputNullTest() throws Exception {
        try {
            war.getWinningPlayerFromThisRound(null,null);
        } catch (WarGameException warGame) {
            assertEquals(warGame.getMessage(),"Either the winning card or the list of current card in the pot was was null");
        }
    }

    @Test
    public void distributeCardsToWinningPlayerAfterRoundAllInputNullTest() throws Exception {
        try {
            war.distributeCardsToWinningPlayerAfterRound(null,null,null);
        } catch (WarGameException warGame) {
            assertEquals(warGame.getMessage(),"One of the input in distributeCardsToWinningPlayerAfterRound was null!!");
        }
    }

    @Test
    public void setNumberOfPlayers() throws Exception {
    }

    @Test
    public void getNumberOfPlayers() throws Exception {
    }

    @Test
    public void setPlayerInList() throws Exception {
    }

    @Test
    public void getListOfPlayers() throws Exception {
    }

    @Test
    public void play1() throws Exception {
    }

}