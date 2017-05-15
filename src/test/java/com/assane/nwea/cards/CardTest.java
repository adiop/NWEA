package com.assane.nwea.cards;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by u2346 on 05/15/17.
 */
public class CardTest {
    Card _card1 = null;
    Card _card2 = null;
    Card _card3 = null;
    Card _card4 = null;

    @Before
    public void setUp() throws Exception {
        _card1 = new Card(Card.FrenchSuit.Clovers.toString(),Card.Rank.A.toString());
        _card2 = new Card(Card.FrenchSuit.Clovers.toString(),Card.Rank.Four.toString());
        _card3 = new Card(Card.FrenchSuit.Clovers.toString(),Card.Rank.A.toString());

    }

    @After
    public void tearDown() throws Exception {
        _card1 = null;
        _card2 = null;
    }

    @Test
    public void nullTest() throws Exception {
        Card card = new Card();
        int result = card. compare(null,_card2);
        assertEquals(result,-1);
    }

    @Test
    public void testGreaterThan() throws Exception {
        Card card = new Card();
        int result = card. compare(_card1,_card2);
        assertEquals(result,2);
    }
    @Test
    public void testEqual() throws Exception {
        Card card = new Card();
        int result = card. compare(_card1,_card3);
        assertEquals(result,0);
    }

    @Test
    public void testLessThan() throws Exception {
        Card card = new Card();
        int result = card. compare(_card2,_card3);
        assertEquals(result,1);
    }




}