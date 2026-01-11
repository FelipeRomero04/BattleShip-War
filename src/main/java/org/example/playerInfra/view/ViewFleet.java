package org.example.playerInfra.view;

import org.example.Entitys.Board;
import org.example.Entitys.Point;
import org.example.Entitys.Ship;
import org.example.playerInfra.exceptions.InvalidCoordinateException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewFleet {
    private final Scanner input = new Scanner(System.in);
    private final List<Ship> playerShips = new ArrayList<>();

    public List<Ship> createFleet(Board board){

        while(true){
            System.out.print("Quantas células terá seu navio: ");
            int cells = Integer.parseInt(input.nextLine().trim());

            if (cells > 6) {
                throw new IllegalArgumentException("O máximo de células permitidos é 6.");
            }

            List<Point> points = new ArrayList<>();
            board.printBoard();

            for (int i = 3; i > 0 ; i--) {  //retry mechanism
                try {
                    points = positioningShips(board, cells);
                    break;
                } catch (InvalidCoordinateException e) {
                    System.err.println(e.getMessage());
                    System.out.println("Tentativas restantes: " + i);
                }
            }

            playerShips.add(new Ship(points));

            System.out.println("Adicionar um novo navio? SIM(1) / NÃO(0)");
            int choice = Integer.parseInt(input.nextLine().trim());

            if(choice == 0){
                return playerShips;
            }

            if(choice > 1){
                System.out.println("Escolha indefinida. Sua frota tem "+ playerShips.size() + " Navios.");
                return playerShips;
            }
        }
    }

    private List<Point> positioningShips(Board board, int cells){
        List<Point> points = new ArrayList<>();


        for (int i = 0; i < cells; i++) {

            System.out.print("Linha: ");
            int line = Integer.parseInt(input.nextLine().trim());
            if(line < 0 || line > board.getWidth()){
                throw new InvalidCoordinateException("O eixo X escolhido não existe no tabuleiro.");
            }

            System.out.print("Coluna: ");
            int column = Integer.parseInt(input.nextLine().trim());
            if(column < 0 || column > board.getWidth()){
                throw new InvalidCoordinateException("O eixo X escolhido não existe no tabuleiro.");
            }

            Point point = new Point(line, column);
            isOverLap(board, point);

            points.add(point);

            board.markBoard(point, "N");
            board.printBoard();
        }
        return points;
    }


    public Point hitPoint(Board board){

        System.out.println("Coordenadas de Ataque:");
        System.out.print("X: ");
        int x = Integer.parseInt(input.nextLine().trim());
        if(x > board.getWidth() || x < 0){
            throw new InvalidCoordinateException("Eixo X não existe dentro do tabuleiro");
        }

        System.out.print("Y: ");
        int y = Integer.parseInt(input.nextLine().trim());
        if(y > board.getWidth() || y < 0){
            throw new InvalidCoordinateException("Eixo Y não existe dentro do tabuleiro");

        }
        return new Point(x,y);
    }

    private void isOverLap(Board board, Point point){
        if(board.getCoordinate(point).equals("N")) {
            throw new InvalidCoordinateException("Já existe um návio posicionado nessa posição.");
        }
    }




}




//vai criar um ship