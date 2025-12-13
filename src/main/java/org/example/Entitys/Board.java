package org.example.Entitys;

import java.util.Arrays;

public class Board {
    private final int height;
    private final int width;
    private String[][] dimensity;


    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.dimensity = new String[height][width];
        for (String[] arr : dimensity) {
            Arrays.fill(arr, "~");
        }
    }

    public void validBoard(Board board){
        if(board.getWidth() < 3 && board.getHeight() < 3){
            throw new IllegalArgumentException("Tamanho do tabuleiro inválido");
        }

    }

    public void printBoard(){
        for (String[] line : dimensity){
            for (String column : line){
                System.out.print(column);
            }
            System.out.println();
        }
    }


    public void markBoard(Point point, String mark){
        this.dimensity[point.X][point.Y] = mark;
    }

    public String[][] getDimensity() {
        return dimensity;
    }

    public void setDimensity(String[][] dimensity) {
        this.dimensity = dimensity;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
