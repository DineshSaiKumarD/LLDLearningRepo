package SnakeAndLadder.entities;

import java.util.Map;

public class Board {

    private int boardId;
    private int size;

    /*private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;*/
    //anyway we need to know which poistion they move to, so we can merge them into one map..
    private Map<Integer, Integer> jumps;

    public Board(int boardId, int size, Map<Integer, Integer> jumps) {
        this.boardId = boardId;
        this.size = size;
        this.jumps = jumps;
    }

    public int resolveJump(int position) {
        if(position > size) {
            return position; //invalid move
        }
        return jumps.getOrDefault(position, position);
    }


    public int getSize() {
        return size;
    }
}
