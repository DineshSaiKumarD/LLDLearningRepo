package Cricbuzz.listeners;

public class MobileAppListners implements ScoreListener{

    @Override
    public void onScoreUpdate(int runs, int wickets, double overs) {
        System.out.println("Mobile App - Score Update: " + runs + "/" + wickets + " in " + overs + " overs.");
    }
}
