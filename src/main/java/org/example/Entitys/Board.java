package org.example.Entitys;

import java.util.Arrays;

public class Board {
    private final int height;
    private final int width;
    private final String[][] matriz;


    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.matriz = new String[height][width];
        for (String[] arr : matriz) {
            Arrays.fill(arr, "~");
        }
    }

    public void validBoard(Board board){
        if(board.getWidth() < 3 && board.getHeight() < 3){
            throw new IllegalArgumentException("Tamanho do tabuleiro inválido");
        }

    }

    public void printBoard() {

        int size = matriz.length;

        // Cabeçalho das colunas
        System.out.print("    "); // espaço para alinhar com números da esquerda
        for (int i = 0; i < size; i++) {
            System.out.printf("%3d ", i);
        }
        System.out.println();

        // Linhas
        for (int i = 0; i < size; i++) {
            System.out.printf("%3d  ", i); // número da linha

            for (int j = 0; j < size; j++) {
                System.out.printf("%3s ", matriz[i][j]);
            }
            System.out.println();
        }
    }



    public void markBoard(Point point, String mark){
        this.matriz[point.X][point.Y] = mark;
    }



    public String getCoordinate(Point point) {
        if(point.X >= this.width){point.X = width - 1;}
        if(point.X < 0){point.X = 0;}

        if(point.Y >= this.height){point.Y = height - 1;}
        if(point.Y < 0){point.Y = 0;}

        return matriz[point.X][point.Y];
    }

    public void setCoordinate(Point point, String mark) {
        if(point.X >= this.width){point.X = width - 1;}
        if(point.X < 0){point.X = 0;}

        if(point.Y >= this.height){point.Y = height - 1;}
        if(point.Y < 0){point.Y = 0;}

        this.matriz[point.X][point.Y] = mark;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
