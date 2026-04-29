package Cricbuzz.listeners;

public class CommentaryListners implements ScoreListener {


    @Override
    public void onScoreUpdate(int runs, int wickets, double overs) {
        System.out.println("Commentary: " + runs + " runs, " + wickets + " wickets, " + overs + " overs.");
    }
}
