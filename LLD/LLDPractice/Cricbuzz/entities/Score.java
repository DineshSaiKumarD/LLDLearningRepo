package Cricbuzz.entities;

public class Score {

    private int runs;
    private int wickets;
    private int balls; // Track balls instead of overs to avoid floating point issues

    public Score(int runs, int wickets, double overs) {
        this.runs = runs;
        this.wickets = wickets;
        this.balls = (int)(overs * 10); // Convert overs to balls for backward compatibility
    }

    //note: we can have methods like addRuns, addWickets, addOvers instead of setRuns, setWickets, setOvers to maintain the integrity of the score and avoid accidental overwriting of the score.
    //we should not expose setters
    // because it can effect encapsulation
    // if not used carefully.
    // Instead, we can have methods
    // that update the score based on the events in the game,
    // such as addRuns(int runs), addWicket(), addOver() etc. This way we can ensure that the score is updated in a controlled manner and maintain the integrity of the score.

    /*public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public double getOvers() {
        return overs;
    }

    public void setOvers(double overs) {
        this.overs = overs;
    }*/

        public void addRuns(int runs) {
            this.runs += runs;
        }

        public void addWicket() {
            this.wickets += 1;
        }

        public void addBall() {
            this.balls += 1; // Increment balls for each delivered ball
        }

        public void addOver() {
            this.balls += 6; // Each over consists of 6 balls
        }

    public int getBalls() {
        return balls;
    }

    public int getRuns() {
        return runs;
    }

    public int getWickets() {
        return wickets;
    }

    public double getOvers() {
        return balls / 6.0; // Calculate overs from balls
    }





}
