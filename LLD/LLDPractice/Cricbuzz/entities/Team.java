package Cricbuzz.entities;


import java.util.List;

public class Team {

    private int teamId;
    private String teamName;
    private List<Player> players;

    public Team(int teamId, String teamName, List<Player> players) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.players = players;
    }

    public int getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

        public void removePlayer(Player player) {
            players.remove(player);
        }

}
