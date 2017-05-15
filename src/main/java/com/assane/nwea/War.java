package com.assane.nwea;

import com.assane.nwea.Exceptions.WarGameException;
import com.assane.nwea.cards.Card;
import com.assane.nwea.cards.Deck;
import com.assane.nwea.deckFormat.FrenchSuitsDeck;
import com.assane.nwea.entities.Player;
import com.assane.nwea.games.CardGame;
import com.assane.nwea.games.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by u2346 on 05/13/17.
 * I did not add a lot of comment for because of time.
 * However I tried to used the clean code book best practice and tried to make my variable names meaningfull.
 *
 * Also I did not extend on the War game tie situation. Once again in the interest of time. However I am hoping that the OO design
 * will show that extending on this project should not be too hard.
 */
public class War extends CardGame {
    public static final int numberOfCardInHandThatResultInWinningGame = 52;

    public static void main(String[] args) {
        Game warGame = new War();
        warGame.setNumberOfPlayers(4);

        for (int i = 1; i <= warGame.getNumberOfPlayers(); i++) {
            Player warGamePlayer = new Player("player" + i);
            warGame.setPlayerInList(warGamePlayer);
        }

        // Now we need a Deck
        Deck deck = new FrenchSuitsDeck();
        deck.shuffleDeckOfCards();

        // Deck deals card to players
        deck.dealDeckOfCards(warGame.getListOfPlayers());

        // Let's see what each player has.
        warGame.getListOfPlayers().forEach(player -> {
            player.printHand();
        });


        // Lets play the game
        warGame.play(warGame.getListOfPlayers());

    }

    @Override
    public void play(List<Player> playerList) {
        warGameRounds(playerList);
    }

    public void warGameRounds(List<Player> playerList) {
        HashMap<String, Card> currentRound = new HashMap<>();
        List<Card> putCardsInList = null;
        List<Card> sortedCards = null;
        String winningPlayerThisRound = null;
        Card winningCard = null;
        Card topCardPicked = null;
        int counter = 0;

        while (true) {
            System.out.println("Counter is " + counter++);
            for (Player player : playerList) {
                topCardPicked = player.pickTopCardInHand();
                if (topCardPicked != null) {
                    currentRound.put(player._name, player.pickTopCardInHand());
                    player.removeCardFromHand();
                }
            }

            try {

                putCardsInList = getCardsFromRound(currentRound);

                // Sort the card
                sortedCards = sortListOfCards(putCardsInList);

                winningCard = getWinningCardFromPot(sortedCards);

                winningPlayerThisRound = getWinningPlayerFromThisRound(currentRound, winningCard);

                distributeCardsToWinningPlayerAfterRound(winningPlayerThisRound, currentRound, playerList);

                if (doWeHaveAWinner(playerList)) {
                    break;
                }
            } catch (WarGameException warGame) {
                System.out.println("The system broke down with the following error: " + warGame.getMessage());
            }
        }

    }

    public Boolean doWeHaveAWinner(List<Player> playerList) throws WarGameException {
        if (playerList == null) {
            throw new WarGameException("The list of player in doWeHaveAWinner is null!!");
        }
        for (Player player : playerList) {
            if (player.getCardResultSize() == numberOfCardInHandThatResultInWinningGame) {
                System.out.println("****************************************************");
                System.out.println("The winner is " + player.get_name());
                System.out.println("****************************************************");
                return true;
            }
        }
        return false;
    }

    public List<Card> getCardsFromRound(HashMap map) throws WarGameException {
        if (map == null) {
            throw new WarGameException("The key value pair representing the cards in the round was null!!");
        }
        List<Card> cardsInCurrentRound = new ArrayList<>();
        map.forEach((k, v) -> cardsInCurrentRound.add((Card) v));
        return cardsInCurrentRound;
    }

    public List<Card> sortListOfCards(List<Card> cardList) throws WarGameException {
        if (cardList == null) {
            throw new WarGameException("The list in the sortListOfCards was null");
        }
        // Sort the card
        Collections.sort(cardList, new Card());
        System.out.println("Let's list the ordered card. The size is " + cardList.size());
        if (cardList != null) {
            for (Card card : cardList) {
                System.out.println(card.toString());
            }
        }

        return cardList;
    }

    public Card getWinningCardFromPot(List<Card> sortedList) throws WarGameException {
        if (sortedList == null) {
            throw new WarGameException("The list in the getWinningCardFromPot was null");
        }
        return sortedList.get(0);
    }

    public String getWinningPlayerFromThisRound(HashMap<String, Card> currentRound, Card winningCard) throws WarGameException {
        if (currentRound == null || winningCard == null) {
            throw new WarGameException("Either the winning card or the list of current card in the pot was was null");
        }
        for (String playerName : currentRound.keySet()) {
            if (currentRound.get(playerName)._rank.equalsIgnoreCase(winningCard._rank)) {
                return playerName;
            }
        }
        return null;
    }

    public void distributeCardsToWinningPlayerAfterRound(String winnigPlayer, HashMap<String, Card> currentRound, List<Player> playerList) throws WarGameException {
        if (winnigPlayer == null || currentRound == null || playerList == null) {
            throw  new WarGameException("One of the input in distributeCardsToWinningPlayerAfterRound was null!!");
        }
        List<Card> results = getCardsFromRound(currentRound);
        for (Player player : playerList) {
            if (player.get_name().equalsIgnoreCase(winnigPlayer)) {
                currentRound.forEach((k, v) -> {
                    player.resultHand((Card) v);
                });
            }
        }

    }


}

