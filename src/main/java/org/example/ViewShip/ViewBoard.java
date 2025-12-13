package org.example.ViewShip;

import org.example.Entitys.Board;

public class ViewBoard {
    private final Board board;

    public ViewBoard(Board board) {
        this.board = board;
    }

    public void printBoard(){
        for (String[] line : board.getDimensity()){
            for (String column : line){
                System.out.print(column);
            }
            System.out.println();
        }
    }
}
