package org.example.Rules;

import org.example.Entitys.Board;
import org.example.Entitys.Point;
import org.example.Entitys.Ship;
import java.util.ArrayList;
import java.util.List;

public class ShipRules {
    private final Board board;

    public ShipRules(Board board) {
        this.board = board;

    }

    public void superimposeShip(Ship ship){
        try{
            for (Point point : ship.getPositionShips()) {
                if (board.getDimensity()[point.X][point.Y].equals("O")) {
                    throw new IllegalArgumentException("Um navio ja esta posicionado neste local");

                } else if (board.getDimensity()[point.X][point.Y].equals("X")) {
                    throw new IllegalArgumentException("Essa área pertence a um navio proximo");
                }
            }

        }catch (IndexOutOfBoundsException e){
            throw new NullPointerException("Campo selecionado está fora do tabuleiro");
        }
    }

    public boolean yIsSequencial(Ship ship) {
        boolean xEquals = ship.getXPoints().stream().allMatch(n -> n.equals(ship.getXPoints().get(0)));

        if (xEquals) { //Garante posições sequenciais na vertical
            for (int i = 1; i < ship.getXPoints().size(); i++) {
                if (ship.getYPoints().get(i) == ship.getYPoints().get(i - 1) + 1 ||
                    ship.getYPoints().get(i) == ship.getYPoints().get(i - 1) - 1){
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean xIsSequencial(Ship ship) {
        boolean yEquals = ship.getYPoints().stream().allMatch(n -> n.equals(ship.getYPoints().get(0)));

        if (yEquals) { //Garante posições sequenciais na vertical
            for (int i = 1; i < ship.getYPoints().size(); i++) {
                if (ship.getYPoints().get(i) == ship.getYPoints().get(i - 1) + 1 ||
                    ship.getYPoints().get(i) == ship.getYPoints().get(i - 1) - 1){
                    return true;
                }
            }
            return false;
        }
        return false;
    }


//    public boolean isSequencial(Ship ship) {
//        boolean xEquals = ship.getXPoints().stream().allMatch(n -> n.equals(ship.getXPoints().get(0)));
//        boolean yEquals = ship.getYPoints().stream().allMatch(n -> n.equals(ship.getYPoints().get(0)));
//
//        if (xEquals) { //Garante posições sequenciais na vertical
//            for (int i = 1; i < ship.getXPoints().size(); i++) {
//                if (ship.getYPoints().get(i) == ship.getYPoints().get(i - 1) + 1) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        if (yEquals) { //Garante posições sequenciais na horizontal
//            for (int i = 1; i < ship.getYPoints().size(); i++) {
//                if (ship.getXPoints().get(i) == ship.getXPoints().get(i - 1) + 1) {
//                    return true;
//                }
//            }
//            return false;
//        }
//        return false;
//
//    }

    // y/xEqual -> Verifica se as posições estão na horizontal ou vertical
    // Apos isso, o ponto que for igual, verifica se o outro ponto
    // é sequencial


    public void offLimits(Ship ship){
        int index = 0;

        while(index < ship.getPositionShips().size()){
            Point point = ship.getPositionShips().get(index);

            for(int xLine = -1; xLine <= 1; xLine++){
                for (int yLine = -1; yLine <= 1 ; yLine++){
                    int newLine = point.X + xLine;
                    int newColumn = point.Y + yLine;

                    board.getDimensity()[newLine][newColumn] = "P";
                }
            }
            index++;
        }
    }


}



