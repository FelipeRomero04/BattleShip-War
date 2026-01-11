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

    public String[][] getMatriz() {
        return matriz;
    }

    public void setCoordinate(int axleX, int axleY, String mark) {
        this.matriz[axleX][axleY] = mark;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
