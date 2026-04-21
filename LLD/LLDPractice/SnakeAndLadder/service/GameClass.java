package SnakeAndLadder.service;

import SnakeAndLadder.entities.Board;
import SnakeAndLadder.entities.Dice;
import SnakeAndLadder.entities.Player;

import java.util.Queue;
import java.util.Scanner;

public class GameClass {
    
    private String gameId;
    private Board board;
    private Queue<Player> playersQueue; // Queue to manage player turns
    
    private boolean isGameOver;
    
    private Dice dice;
    
    
    public GameClass(String gameId, Board board, Queue<Player> playersQueue, boolean isGameOver,Dice dice) {
        this.gameId = gameId;
        this.board = board;
        this.playersQueue = playersQueue;
        this.isGameOver = isGameOver;
        this.dice = dice;
    }
    
    public String getGameId() {
        return gameId;
    }
    
    public Board getBoard() {
        return board;
    }
    
    public Queue<Player> getPlayersQueue() {
        return playersQueue;
    }
    
    int updatePlayerPosition(Player player, int newPosition) {
         // Logic to update the player's position on the board
         // This may involve checking for snakes or ladders and updating accordingly
         int oldPosition = player.getCurrentPosition();
         player.setCurrentPosition(newPosition);
         System.out.println("    [UPDATE] " + player.getName() + " moved from " + oldPosition + " to " + newPosition);
         return player.getCurrentPosition();
     }
    
    public void
    startGame() {
         // Logic to start the game, initialize player positions, and manage turns
         Scanner scanner = new Scanner(System.in);
         int turns = 0;
         System.out.println(" Game started!");
         System.out.println();
         
         while (!isGameOver()) {
             Player currentPlayer = playersQueue.poll();
             turns++;
             System.out.println("--- TURN " + turns + " ---");
             System.out.println(" Current Player: " + currentPlayer.getName());
             System.out.println(" Current Position: " + currentPlayer.getCurrentPosition());
             
             System.out.print("Press ENTER to roll dice...");
             scanner.nextLine();
             
             int currentPosition = currentPlayer.getCurrentPosition();
             int diceRoll = dice.rollDice();
             System.out.println("[DICE] Rolled: " + diceRoll);
             
             int newPosition = currentPosition + diceRoll;
             System.out.println("New position would be: " + newPosition);

             if(newPosition > board.getSize()) {
                 System.out.println("crossing the board so staying at current position: " + currentPosition);
                 newPosition = currentPosition; // Player stays in the same position if overshooting
             }
             
             newPosition = board.resolveJump(newPosition);
             if (newPosition != (currentPosition + diceRoll)) {
                 System.out.println(" Jump detected! Final position: " + newPosition);
             }
             
             updatePlayerPosition(currentPlayer, newPosition);
             
             if(checkWinCondition(currentPlayer)) {
                 isGameOver = true;
                 break;
             }
             playersQueue.add(currentPlayer);
             System.out.println();
             // Logic to roll dice, move player, and check for win condition
             // After the turn, add the player back to the queue if they haven't won
         }
         scanner.close();
         
     }

    private boolean isGameOver() {
        return isGameOver;
    }
    
    boolean checkWinCondition(Player player) {
         // Logic to check if the player has won the game (e.g., reached the last square)
         if (player.getCurrentPosition() == board.getSize()) {
             System.out.println("========== GAME WINNER ==========");
             System.out.println("Playerr.. " + player.getName() + " won the game");
             System.out.println("==================================");
             return true; // Indicating win
         }
         return false; // Indicating game will continue
     }


}
