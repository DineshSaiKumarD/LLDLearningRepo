package SnakeAndLadder.entities;



public class Player {

    int playerId;
    String name;
    int currentPosition;

    public Player(int playerId, String name) {
        this.playerId = playerId;
        this.name = name;
        this.currentPosition = 0; // Starting position..
    }

   public  int getCurrentPosition() {
        return currentPosition;
    }

   public int setCurrentPosition(int newPosition) {
        this.currentPosition = newPosition;
        return this.currentPosition;
    }

    public String getName() {
        return name;
    }


}
