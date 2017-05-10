package br.com.mobile.gerson.controleracha.controller;

import android.content.Context;

import java.util.ArrayList;

import br.com.mobile.gerson.controleracha.model.Config;
import br.com.mobile.gerson.controleracha.model.Player;
import br.com.mobile.gerson.controleracha.model.Team;

/**
 * Created by gerson on 01/05/2017.
 */

public class TeamController {
    private Team team1;
    private Team team2;
    private Team teamOut;
    private ArrayList<Player> allPlayers;
    private int teamSize = 5;

    public TeamController() {
        allPlayers = new ArrayList<Player>();
        init();
    }

    public void addPlayer(Player player) {
        allPlayers.add(player);
        init();
    }

    public void load(Context context) {
        Player player = new Player(context);
        allPlayers = player.getAll();
        Config config = new Config(context);
        if (config.find(1))
        teamSize = config.getTeamSize();
    }

    private void init() {
        team1 = new Team(teamSize);
        team2 = new Team(teamSize);
        teamOut = new Team();
    }

    private Team copyTeam(int low, int high) throws Exception {
        Team result = new Team(getTeamSize());
        for (int i = low; i < high; i++) {
            result.add(allPlayers.get(i));
        }
        return result;
    }

    public void makeTeam1() throws Exception {
        team1 = copyTeam(0, getTeamSize());
    }

    public void makeTeam2() throws Exception {
        team2 = copyTeam(getTeamSize(), 2 * getTeamSize());
    }

    public void makeTeamOut() throws Exception {
        teamOut = copyTeam(2 * getTeamSize(), allPlayers.size());
    }

    public void makeAllTeams() throws Exception {
        makeTeam1();
        makeTeam2();
        makeTeamOut();
    }

    public ArrayList<Player> getAllPlayers() {
        return allPlayers;
    }

    public void doTeamWins(Team first, Team second, Team third) throws Exception {
        ArrayList<Player> temp = new ArrayList<Player>();

        temp.addAll(first.getPlayers());
        temp.addAll(second.getPlayers());
        temp.addAll(third.getPlayers());
        allPlayers = temp;
        makeAllTeams();
    }

    public void team1Wins() throws Exception {
        doTeamWins(team1, teamOut, team2);
    }

    public void team2Wins() throws Exception {
        doTeamWins(team2, teamOut, team1);
    }

    public void tiedGame() throws Exception {
        team2Wins();
    }

    public ArrayList<String> getListTeams() {
        ArrayList<String> result = new ArrayList<String>();

        result.add(getTeam1().getPlayersToShow());
        result.add(getTeam2().getPlayersToShow());
        result.add(getTeamOut().getPlayersToShow());

        return result;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public Team getTeamOut() {
        return teamOut;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
}
