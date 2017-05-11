package br.com.mobile.gerson.controleracha;

import org.junit.Test;

import java.util.ArrayList;

import br.com.mobile.gerson.controleracha.controller.TeamController;
import br.com.mobile.gerson.controleracha.model.Player;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addPlayerController() throws Exception {
        TeamController teamController = new TeamController();

        teamController.addPlayer(new Player("Gerson"));
    }

    @Test
    public void team1PlayerController() throws Exception {
        TeamController teamController = new TeamController();

        setPlayers(teamController);

        teamController.makeTeam1();
        assertEquals(teamController.getTeam1().getPlayer(0).getName(), "Gerson");
        assertEquals(teamController.getTeam1().getPlayer(4).getName(), "Adriana");
    }

    @Test
    public void team2PlayerController() throws Exception {
        TeamController teamController = new TeamController();

        setPlayers(teamController);

        teamController.makeTeam2();
        assertEquals(teamController.getTeam2().getPlayer(0).getName(), "Maria");
        assertEquals(teamController.getTeam2().getPlayer(4).getName(), "Junior");
    }

    @Test
    public void teamOutPlayerController() throws Exception {
        TeamController teamController = new TeamController();

        setPlayers(teamController);

        teamController.makeTeamOut();
        assertEquals(teamController.getTeamOut().getPlayer(0).getName(), "Raimundo");
        assertEquals(teamController.getTeamOut().getPlayer(1).getName(), "Arnaldo");
    }

    @Test
    public void team1WinsPlayerController() throws Exception {
        TeamController teamController = new TeamController();

        setPlayers(teamController);

        teamController.makeAllTeams();
        teamController.team1Wins();

        assertEquals(teamController.getTeam1().getPlayer(0).getName(), "Gerson");
        assertEquals(teamController.getTeam1().getPlayer(4).getName(), "Adriana");

        assertEquals(teamController.getTeam2().getPlayer(0).getName(), "Raimundo");
        assertEquals(teamController.getTeam2().getPlayer(4).getName(), "Dido");

        assertEquals(teamController.getTeamOut().getPlayer(0).getName(), "Tadeu");
        assertEquals(teamController.getTeamOut().getPlayer(1).getName(), "Junior");
    }

    @Test
    public void team2WinsPlayerController() throws Exception {
        TeamController teamController = new TeamController();

        setPlayers(teamController);

        teamController.makeAllTeams();
        teamController.team2Wins();

        assertEquals(teamController.getTeam1().getPlayer(0).getName(), "Maria");
        assertEquals(teamController.getTeam1().getPlayer(4).getName(), "Junior");

        assertEquals(teamController.getTeam2().getPlayer(0).getName(), "Raimundo");
        assertEquals(teamController.getTeam2().getPlayer(4).getName(), "Castro");

        assertEquals(teamController.getTeamOut().getPlayer(0).getName(), "Marcia");
        assertEquals(teamController.getTeamOut().getPlayer(1).getName(), "Adriana");
    }

    @Test
    public void tiedGamePlayerController() throws Exception {
        TeamController teamController = new TeamController();

        setPlayers(teamController);

        teamController.makeAllTeams();
        teamController.tiedGame();

        assertEquals(teamController.getTeam1().getPlayer(0).getName(), "Maria");
        assertEquals(teamController.getTeam1().getPlayer(4).getName(), "Junior");

        assertEquals(teamController.getTeam2().getPlayer(0).getName(), "Raimundo");
        assertEquals(teamController.getTeam2().getPlayer(4).getName(), "Castro");

        assertEquals(teamController.getTeamOut().getPlayer(0).getName(), "Marcia");
        assertEquals(teamController.getTeamOut().getPlayer(1).getName(), "Adriana");
    }

    @Test
    public void listTeamsPlayerController() throws Exception {
        TeamController teamController = new TeamController();

        setPlayers(teamController);
        teamController.makeAllTeams();
        ArrayList<String> team = teamController.getListTeams();

        assertEquals(team.get(0), " | Gerson | Alves | Castro | Marcia | Adriana | ");
    }

    private void setPlayers(TeamController teamController) {
        teamController.addPlayer(new Player("Gerson"));
        teamController.addPlayer(new Player("Alves"));
        teamController.addPlayer(new Player("Castro"));
        teamController.addPlayer(new Player("Marcia"));
        teamController.addPlayer(new Player("Adriana"));
        teamController.addPlayer(new Player("Maria"));
        teamController.addPlayer(new Player("Rei"));
        teamController.addPlayer(new Player("Dido"));
        teamController.addPlayer(new Player("Tadeu"));
        teamController.addPlayer(new Player("Junior"));
        teamController.addPlayer(new Player("Raimundo"));
        teamController.addPlayer(new Player("Arnaldo"));
    }
}