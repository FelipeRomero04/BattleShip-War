package org.example.playerInfra.view;

import org.example.Entitys.Board;
import org.example.Entitys.Point;
import org.example.Entitys.Ship;
import org.example.playerInfra.exceptions.CoordinateIsNotSequencial;
import org.example.playerInfra.exceptions.InvalidCoordinateException;

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
                if(line < 0 || line > board.getWidth()){
                    throw new InvalidCoordinateException("O eixo X escolhido não existe no tabuleiro.");
                }

                System.out.print("Coluna: ");
                int column = Integer.parseInt(input.nextLine().trim());
                if(column < 0 || column > board.getWidth()){
                    throw new InvalidCoordinateException("O eixo X escolhido não existe no tabuleiro.");
                }

                Point point = new Point(line, column);
                points.add(point);


                board.markBoard(point, "N");
                board.printBoard();
            }
            playerShips.add(new Ship(points));

            System.out.println("Adicionar um novo navio? SIM(0) / NÃO(1)");
            int choice = Integer.parseInt(input.nextLine().trim());

            if(choice == 1){
                return playerShips;
            }

            if(choice > 1){
                System.out.println("Escolha indefinida. Sua frota tem "+ playerShips.size() + " Navios.");
                return playerShips;
            }
        }
    }

    public Point hitPoint(Board board){

        System.out.println("Coordenadas de Ataque:");
        System.out.print("X: ");
        int x = Integer.parseInt(input.nextLine().trim()); //TODO: validação simples
        if(x > board.getWidth() || x < 0){
            throw new CoordinateIsNotSequencial("Eixo X não existe dentro do tabuleiro");
        }
        System.out.print("Y: ");
        int y = Integer.parseInt(input.nextLine().trim()); //TODO: validação simples
        if(y > board.getWidth() || y < 0){
            throw new CoordinateIsNotSequencial("Eixo Y não existe dentro do tabuleiro");

        }
        return new Point(x,y);
    }




}




//vai criar um ship