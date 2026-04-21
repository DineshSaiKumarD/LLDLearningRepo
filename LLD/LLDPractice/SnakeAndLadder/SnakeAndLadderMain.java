package SnakeAndLadder;

import SnakeAndLadder.entities.Board;
import SnakeAndLadder.entities.Dice;
import SnakeAndLadder.entities.Player;
import SnakeAndLadder.service.GameClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class SnakeAndLadderMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========== WELCOME TO SNAKE AND LADDER GAME ==========");
        System.out.println();
        
        //create jumps
        Map<Integer, Integer> jumps = new HashMap<>();
        
        jumps.put(3, 22); // ladder
        jumps.put(5, 8);  // ladder
        jumps.put(11, 26); // ladder
        jumps.put(20, 29); // ladder
        jumps.put(17, 4);  // snake
        jumps.put(19, 7);  // snake
        jumps.put(27, 1);  // snake 
        
        System.out.println(" Board jumps configured with 4 ladders and 3 snakes");
        
        Board board = new Board(1,50
                ,jumps);
        System.out.println(" Board created: Size = 100");
        
        //crate players
        Player player1 = new Player(1, "Pawan");
        Player player2 = new Player(2, "Dinesh");
        Player player3 = new Player(3, "Kalyan");
        
        System.out.println(" Players created:");
        System.out.println("   Player 1: " + player1.getName());
        System.out.println("   Player 2: " + player2.getName());
        System.out.println("  Player 3: " + player3.getName());

        Queue<Player> playersQueue = new java.util.LinkedList<>();
        playersQueue.add(player1);
        playersQueue.add(player2);
        playersQueue.add(player3);
        
        System.out.println(" Players added to game queue");
        
        Dice dice = new Dice(6);
        System.out.println(" Dice created: 6 sides");
        
        System.out.println();
        System.out.println("========== GAME INITIALIZATION COMPLETE ==========");
        System.out.println();
        System.out.println("Press ENTER to start the game...");
        scanner.nextLine();
        
        GameClass game = new GameClass("1",board, playersQueue,false,dice);
        
        game.startGame();
        
        System.out.println();
        System.out.println("========== GAME END ==========");
        scanner.close();
        
       
    }
}
