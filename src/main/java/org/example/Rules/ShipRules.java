package org.example.Rules;

import org.example.Entitys.Board;
import org.example.Entitys.Point;
import org.example.Entitys.Ship;
import java.util.ArrayList;
import java.util.List;

public class ShipRules {
    private final Board board;
    private final Ship ship;
//    private final List<Integer> xPoints;
//    private final List<Integer> yPoints;

    public ShipRules(Board board , Ship ship) {
        this.board = board;
        this.ship = ship;

        this.xPoints = new ArrayList<>(ship.getPositionShips().stream().map(p -> p.X).sorted().toList());
        this.yPoints = new ArrayList<>(ship.getPositionShips().stream().map(p -> p.Y).sorted().toList());
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


//    public boolean isSequencial() {
//        boolean xEquals = xPoints.stream().allMatch(n -> n.equals(xPoints.get(0)));
//        boolean yEquals = yPoints.stream().allMatch(n -> n.equals(yPoints.get(0)));
//
//        if (xEquals) { //Garante posições sequenciais na vertical
//            for (int i = 1; i < this.xPoints.size(); i++) {
//                if (yPoints.get(i) == yPoints.get(i - 1) + 1) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        if (yEquals) { //Garante posições sequenciais na horizontal
//            for (int i = 1; i < this.yPoints.size(); i++) {
//                if (xPoints.get(i) == xPoints.get(i - 1) + 1) {
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


    public boolean isSequencial(Ship ship) {
        boolean xEquals = ship.getXPoints().stream().allMatch(n -> n.equals(ship.getXPoints().get(0)));
        boolean yEquals = ship.getYPoints().stream().allMatch(n -> n.equals(ship.getYPoints().get(0)));

        if (xEquals) { //Garante posições sequenciais na vertical
            for (int i = 1; i < this.ship.getXPoints().size(); i++) {
                if (ship.getYPoints().get(i) == ship.getYPoints().get(i - 1) + 1) {
                    return true;
                }
            }
            return false;
        }

        if (yEquals) { //Garante posições sequenciais na horizontal
            for (int i = 1; i < this.ship.getYPoints().size(); i++) {
                if (ship.getXPoints().get(i) == ship.getXPoints().get(i - 1) + 1) {
                    return true;
                }
            }
            return false;
        }
        return false;

    }


    public void offLimits(Ship ship){
        int index = 0;

        while(index < ship.getPositionShips().size()){
            Point point = ship.getPositionShips().get(index);

            for(int xLine = -1; xLine <= 1; xLine++){
                for (int yLine = -1; yLine <= 1 ; yLine++){
                    int newLine = point.X + xLine;
                    int newColumn = point.Y + yLine;

                    board.getDimensity()[newLine][newColumn] = "O";
                }
            }
            index++;
        }
    }


}



