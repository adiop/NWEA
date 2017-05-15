package com.assane.nwea.games;

import com.assane.nwea.entities.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by u2346 on 05/13/17.
 */
public class CardGame implements Game {
    int _numberOfPlayers;
    List<Player> listOfPlayers = null;

    @Override
    public void setNumberOfPlayers(int numberOfPlayers) {
        _numberOfPlayers = numberOfPlayers;
    }

    @Override
    public int getNumberOfPlayers() {
        return _numberOfPlayers;
    }

    @Override
    public void setPlayerInList(Player player) {
        if (listOfPlayers == null) {
            listOfPlayers = new ArrayList<Player>();
            listOfPlayers.add(player);
        } else {
            listOfPlayers.add(player);
        }
    }

    public List<Player> getListOfPlayers () {
        return listOfPlayers;
    }

    @Override
    public void play(List<Player> playerList) {

    }


}
