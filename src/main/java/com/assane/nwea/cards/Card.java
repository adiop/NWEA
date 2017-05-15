package com.assane.nwea.cards;

import java.util.Comparator;

/**
 * Created by u2346 on 05/13/17.
 */
public class Card implements Comparator<Card> {

    @Override
    public int compare(Card t, Card t1) {
        if (t == null || t1 == null)
            return -1;
        if (t.getIntegerRank(t._rank) < t1.getIntegerRank(t1._rank)) {
            return 1;
        } else if (t.getIntegerRank(t._rank) == t1.getIntegerRank(t1._rank)) {
            return 0;
        }
        return 2;
    }


    static public enum FrenchSuit {
        Hearts, Tiles, Clovers, Pikes, Joker
    }

    static public enum ItalianSuit {
        Cups, Coins, CLubs, Swords, Joker
    }

    static public enum SpanishSuit {
        Cups, Coins, Acorns, Shields, Joker
    }

    static public enum SwissGermanSuit {
        Roses, Bells, Acorns, Shields, Joker
    }

    static public enum GermanSuit {
        Hearts, Bells, Acorns, Leaves, Joker
    }

    static public enum Rank {
        TWO,Three,Four,Five,Six,Seven,Eight,Nine,Ten,J,Q,K,A
    }

    public String _suit;
    public String _rank;

    public Card () {}

    public Card (String suit , String rank) {
        _suit = suit;
        _rank = rank;
    }

    @Override
    public String toString() {
        return "This card suit is " + _suit + " and this card rank is " + _rank;
    }

    private int getIntegerRank(String rank) {
        if (rank.equalsIgnoreCase("TWO")) {
            return 2;
        }
        if (rank.equalsIgnoreCase("Three")) {
            return 3;
        }
        if (rank.equalsIgnoreCase("Four")) {
            return 4;
        }
        if (rank.equalsIgnoreCase("Five")) {
            return 5;
        }
        if (rank.equalsIgnoreCase("Six")) {
            return 6;
        }
        if (rank.equalsIgnoreCase("Seven")) {
            return 7;
        }
        if (rank.equalsIgnoreCase("Eight")) {
            return 8;
        }
        if (rank.equalsIgnoreCase("Nine")) {
            return 9;
        }
        if (rank.equalsIgnoreCase("Ten")) {
            return 10;
        }
        if (rank.equalsIgnoreCase("J")) {
            return 11;
        }
        if (rank.equalsIgnoreCase("Q")) {
            return 12;
        }
        if (rank.equalsIgnoreCase("K")) {
            return 13;
        }
        if (rank.equalsIgnoreCase("A")) {
            return 14;
        }

        return 0;
    }
}
