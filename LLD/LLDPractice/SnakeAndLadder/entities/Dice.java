package SnakeAndLadder.entities;


//cane be configurable because we may have diff types of dice in future...
public class Dice {

    int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public int rollDice() {
        return (int)(Math.random() * sides) + 1;
    }


}
