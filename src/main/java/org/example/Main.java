package org.example;

import org.example.Entitys.*;
import org.example.GameEngine.Engine;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Board board = new Board(14,14);
        Engine engine = new Engine(board);
        PlayerDTO playerDTO = new PlayerDTO();
        Machine machine = new Machine(board);

        Ship ship1 = new Ship(List.of(new Point(5,6), new Point(5,7)));
        Ship ship2 = new Ship(List.of(new Point(8,2), new Point(8,1)));
        Ship ship3 = new Ship(List.of(new Point(6,12), new Point(6,13)));

        playerDTO.setMyShips(List.of(ship1, ship2));

        List<Point> points = machine.positioningRandom(board,playerDTO);

        for (Point p : points){
            System.out.println(p.X);
            System.out.println(p.Y);
            board.markBoard(p, "M");
        }


        for (String[] str : board.getDimensity()){
            for (String i : str){
                System.out.print(i);
            }
            System.out.println();
        }
//        engine.formingFleet(board, playerDTO);
//
//        System.out.println(playerDTO.getMyShips());


    }
}


//Preciso criar a borda limite dos navios da maquina
// As coordenadas não estão reduzindo quando chegam na borda


//Legenda:

// ~ -> vazio
// O -> navio
// X -> proibido

//Modo sem validação, chamar putShip depois da area de segurança ser feita

