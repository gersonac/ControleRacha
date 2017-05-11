package br.com.mobile.gerson.controleracha.model;

import java.util.ArrayList;

/**
 * Created by gerson on 01/05/2017.
 */

public class Team {
    private ArrayList<Player> players = new ArrayList<Player>();
    private Integer size = Integer.MIN_VALUE;

    public Team(Integer size) {
        this.setSize(size);
    }

    public Team() {
        this.setSize(Integer.MIN_VALUE);
    }

    public void add(Player player) throws Exception {
        if (players.size() < this.getSize() || this.getSize() == Integer.MIN_VALUE)
            players.add(player);
        else
            throw new Exception("Número máximo de jogadores atingido");
    }

    public void remove(Player player) throws Exception {
        if (players.size() > 0)
            players.remove(player);
        else
            throw new Exception("Não existem jogadores");
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<String> getPlayersNames() {
        ArrayList<String> temp = new ArrayList<>();
        for (Player player: players) {
            temp.add(player.getName());
        }
        return temp;
    }

    public String getPlayersToShow() {
        String result = " | ";
        for (Player player: players) {
            result = result.concat(player.getName()).concat(" | ");
        }
        return result;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
