package com.assane.nwea.games;

import com.assane.nwea.entities.Player;

import java.util.List;

/**
 * Created by u2346 on 05/13/17.
 * Any class implementing the game class should set the number of player for the game.
 */
public interface Game {
    void setNumberOfPlayers(int numberOfPlayers);
    int getNumberOfPlayers();
    void setPlayerInList(Player player);
    List<Player> getListOfPlayers ();
    void play (List<Player> playerList);


}
