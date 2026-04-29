package Cricbuzz;

import Cricbuzz.entities.Match;
import Cricbuzz.entities.Player;
import Cricbuzz.entities.Team;
import Cricbuzz.entities.MatchEvent;
import Cricbuzz.entities.EventType;
import Cricbuzz.listeners.CommentaryListners;
import Cricbuzz.listeners.MobileAppListners;

import java.util.ArrayList;
import java.util.List;

public class CricbuzzDriver {
    
    public static void main(String[] args) {
        
        // Create players for Team India
        List<Player> indiaPlayers = new ArrayList<>();
        indiaPlayers.add(new Player("IND1", "Virat Kohli"));
        indiaPlayers.add(new Player("IND2", "Rohit Sharma"));
        indiaPlayers.add(new Player("IND3", "Jasprit Bumrah"));
        indiaPlayers.add(new Player("IND4", "Rishabh Pant"));
        indiaPlayers.add(new Player("IND5", "KL Rahul"));
        indiaPlayers.add(new Player("IND6", "Hardik Pandya"));
        indiaPlayers.add(new Player("IND7", "Ravindra Jadeja"));
        indiaPlayers.add(new Player("IND8", "Mohammed Shami"));
        indiaPlayers.add(new Player("IND9", "Yuzvendra Chahal"));
        indiaPlayers.add(new Player("IND10", "Shikhar Dhawan"));
        indiaPlayers.add(new Player("IND11", "Mohammed Siraj"));
        
        // Create players for Team Australia
        List<Player> australiaPlayers = new ArrayList<>();
        australiaPlayers.add(new Player("AUS1", "Steve Smith"));
        australiaPlayers.add(new Player("AUS2", "David Warner"));
        australiaPlayers.add(new Player("AUS3", "Pat Cummins"));
        australiaPlayers.add(new Player("AUS4", "Alex Carey"));
        australiaPlayers.add(new Player("AUS5", "Glenn Maxwell"));
        australiaPlayers.add(new Player("AUS6", "Marcus Stoinis"));
        australiaPlayers.add(new Player("AUS7", "Adam Zampa"));
        australiaPlayers.add(new Player("AUS8", "Mitchell Starc"));
        australiaPlayers.add(new Player("AUS9", "Josh Hazlewood"));
        australiaPlayers.add(new Player("AUS10", "Aaron Finch"));
        australiaPlayers.add(new Player("AUS11", "Ashton Agar"));
        
        // Create teams
        Team india = new Team(1, "India", indiaPlayers);
        Team australia = new Team(2, "Australia", australiaPlayers);
        
        // Create match
        Match match = new Match(1, india, australia);
        
        // Add listeners
        CommentaryListners commentary = new CommentaryListners();
        MobileAppListners mobileApp = new MobileAppListners();
        
        match.addScoreListener(commentary);
        match.addScoreListener(mobileApp);
        
        // Simulate score updates
        System.out.println("=== CRICBUZZ LIVE SCORE ===");
        System.out.println("India vs Australia");
        System.out.println("============================");
        

        /*
        // Powerplay overs
        match.updateScore(12, 0, (int)1.0);
        match.updateScore(28, 0, (int)2.0);
        match.updateScore(45, 1, (int)3.0);
        match.updateScore(62, 1, (int)4.0);
        match.updateScore(78, 1, (int)5.0);
        match.updateScore(95, 2, (int)6.0);
        
        // Middle overs
        match.updateScore(112, 2, (int)7.0);
        match.updateScore(128, 2, (int)8.0);
        match.updateScore(145, 3, (int)9.0);
        match.updateScore(162, 3, (int)10.0);
        match.updateScore(178, 3, (int)11.0);
        match.updateScore(195, 4, (int)12.0);
        match.updateScore(210, 4, (int)13.0);
        match.updateScore(225, 5, (int)14.0);
        match.updateScore(240, 5, (int)15.0);
        
        // Death overs
        match.updateScore(258, 5, (int)16.0);
        match.updateScore(275, 6, (int)17.0);
        match.updateScore(292, 7, (int)18.0);
        match.updateScore(305, 8, (int)19.0);
        match.updateScore(315, 9, (int)20.0);
        */
        

        // Powerplay overs --- simulating ball by ball events
        // Over 1: 12 runs, 0 wickets
        for(int i = 0; i < 12; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 2: 16 runs, 0 wickets (28-12=16)
        for(int i = 0; i < 16; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 3: 17 runs, 1 wicket (45-28=17)
        for(int i = 0; i < 17; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.WICKET, 1));
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 4: 17 runs, 0 wickets (62-45=17)
        for(int i = 0; i < 17; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 5: 16 runs, 0 wickets (78-62=16)
        for(int i = 0; i < 16; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 6: 17 runs, 1 wicket (95-78=17)
        for(int i = 0; i < 17; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.WICKET, 1));
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Continue with middle overs...
        // Over 7: 17 runs, 0 wickets (112-95=17)
        for(int i = 0; i < 17; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 8: 16 runs, 0 wickets (128-112=16)
        for(int i = 0; i < 16; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 9: 17 runs, 1 wicket (145-128=17)
        for(int i = 0; i < 17; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.WICKET, 1));
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 10: 17 runs, 0 wickets (162-145=17)
        for(int i = 0; i < 17; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 11: 16 runs, 0 wickets (178-162=16)
        for(int i = 0; i < 16; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 12: 17 runs, 1 wicket (195-178=17)
        for(int i = 0; i < 17; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.WICKET, 1));
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 13: 15 runs, 0 wickets (210-195=15)
        for(int i = 0; i < 15; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 14: 15 runs, 1 wicket (225-210=15)
        for(int i = 0; i < 15; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.WICKET, 1));
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 15: 15 runs, 0 wickets (240-225=15)
        for(int i = 0; i < 15; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Death overs
        // Over 16: 18 runs, 0 wickets (258-240=18)
        for(int i = 0; i < 18; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 17: 17 runs, 1 wicket (275-258=17)
        for(int i = 0; i < 17; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.WICKET, 1));
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 18: 17 runs, 1 wicket (292-275=17)
        for(int i = 0; i < 17; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.WICKET, 1));
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 19: 13 runs, 1 wicket (305-292=13)
        for(int i = 0; i < 13; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.WICKET, 1));
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        // Over 20: 10 runs, 1 wicket (315-305=10)
        for(int i = 0; i < 10; i++) {
            match.processEvent(new MatchEvent(EventType.RUN, 1));
        }
        match.processEvent(new MatchEvent(EventType.WICKET, 1));
        match.processEvent(new MatchEvent(EventType.OVER, 1));
        
        System.out.println("============================");
        System.out.println("Match completed!");
    }
}
