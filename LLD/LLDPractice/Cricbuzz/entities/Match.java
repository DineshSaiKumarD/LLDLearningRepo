package Cricbuzz.entities;

import Cricbuzz.listeners.ScoreListener;

import java.util.List;

public class Match {
    private int id;
    private Team team1, team2;
    private Score score;

    private List<ScoreListener> scoreListeners;

    public Match(int id, Team team1, Team team2) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.score = new Score(0, 0, 0.0);
        this.scoreListeners = new java.util.ArrayList<>();
    }

    //here i am just updating the score everytime,
    // but in real world we will have more complex logic
    // to update the score based on the events of the match
    // like runs scored, wickets taken, overs bowled etc.
   /* public void updateScore(int runs, int wickets, int overs) {
        this.score.setRuns(runs);
        this.score.setWickets(wickets);
        this.score.setOvers(overs);
        notifyScoreListeners();
    }*/

    public void processEvent(MatchEvent event) {
        if (event.getEventType() == EventType.RUN) {
            score.addRuns(event.getValue());
        } else if (event.getEventType() == EventType.WICKET) {
            score.addWicket();
        }
            else if (event.getEventType() == EventType.OVER) {
                score.addOver();
            }
        notifyScoreListeners();
    }


    public void addScoreListener(ScoreListener listener) {
        scoreListeners.add(listener);
    }

    private void notifyScoreListeners() {
        for (ScoreListener listener : scoreListeners) {
            listener.onScoreUpdate(score.getRuns(), score.getWickets(), score.getOvers());
        }
    }
}
