package org.example.ViewShip;

import org.example.Entitys.Board;
import org.example.Entitys.Point;
import org.example.Entitys.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreatingShip {
    private final Scanner input = new Scanner(System.in);
    private final List<Point> points = new ArrayList<>();
//    private Board board;


//    public CreatingShip(Board board) {
//        this.board = board;
//    }

    public Ship createShip(Board board){
        System.out.println("Quantas células terá seu navio: ");
        int cells = Integer.parseInt(input.nextLine().trim());

        if(cells > 6){
            throw new IllegalArgumentException("O máximo de células permitidos é 6.");
        }

        for (int i = 0; i <= cells; i++) {
            board.printBoard();

            System.out.print("Linha: ");
            int line = Integer.parseInt(input.nextLine().trim());

            System.out.println("Coluna: ");
            int column = Integer.parseInt(input.nextLine().trim());

            Point point = new Point(line, column);
            points.add(point);
            board.markBoard(point, "N");
        }

        return new Ship(points);

    }

}




//vai criar um ship