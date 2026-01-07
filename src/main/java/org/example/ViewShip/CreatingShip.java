package org.example.ViewShip;

import org.example.Entitys.Board;
import org.example.Entitys.PlayerDTO;
import org.example.Entitys.Point;
import org.example.Entitys.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CreatingShip {
    private final Scanner input = new Scanner(System.in);
    private final Set<String> positiveChoices = Set.of("sim", "s", "ss");


    public Board defineSizeBoard(){
        System.out.println("DEFININDO TAMANHO DO TABULEIRO:");

        System.out.println("ALTURA: ");
        int height = Integer.parseInt(input.nextLine()); //TODO: Validar

        System.out.println("LARGURA: ");
        int width = Integer.parseInt(input.nextLine());

        return new Board(height, width);
    }



    public List<Ship> createShips(Board board){
        List<Ship> playerShips = new ArrayList<>();

        while(true){
            System.out.println("Quantas células terá seu navio: ");
            int cells = Integer.parseInt(input.nextLine().trim());

            if (cells > 6) {
                throw new IllegalArgumentException("O máximo de células permitidos é 6.");
            }

            List<Point> points = new ArrayList<>();

            board.printBoard();
            for (int i = 0; i < cells; i++) {

                System.out.print("Linha: ");
                int line = Integer.parseInt(input.nextLine().trim());

                System.out.print("Coluna: ");
                int column = Integer.parseInt(input.nextLine().trim());

                Point point = new Point(line, column);
                points.add(point);


                board.markBoard(point, "N");
                board.printBoard();
            }
            playerShips.add(new Ship(points));

            System.out.println("Adicionar um novo navio? ");
            String choice = input.nextLine().trim().toLowerCase();

            if (positiveChoices.contains(choice)) {
                continue;
            }
            return playerShips;
        } //Mudar para retornar um Player

    }

    public Point hitPoint(){

        System.out.println("Coordenadas de Ataque:");
        System.out.print("X: ");
        int x = Integer.parseInt(input.nextLine().trim()); //TODO: validação simples

        System.out.print("Y: ");
        int y = Integer.parseInt(input.nextLine().trim()); //TODO: validação simples

        return new Point(x,y);
    }




}




//vai criar um ship