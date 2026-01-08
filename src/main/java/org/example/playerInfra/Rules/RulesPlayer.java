package org.example.playerInfra.Rules;

import org.example.Entitys.*;
import org.example.playerInfra.exceptions.CoordinateIsNotSequencial;
import org.example.playerInfra.exceptions.InvalidCoordinateException;

import java.util.List;

public class RulesPlayer {


    public PlayerDTO formingFleet(Board board,List<Ship> ships){  //Formando frota
        for(Ship ship : ships){
            superimposeShip(board,ship);
            if(NotIsSequencial(ship)){
                throw new CoordinateIsNotSequencial("Os navio devem ser posicionados sequencialmente, na horizontal ou vertical.");
            }
            offLimits(board, ship);
        }
        return new PlayerDTO(ships);
    }

    public void attackingPoint(Board board,Machine machine, Point pointHit){
        for (Ship shipMachine :  machine.getMachineShips()){
            for (Point pointShip : shipMachine.getPositionShips()){
                if(machine.comparePoint(pointHit, pointShip)){
                    board.markBoard(pointHit, "X");
                    shipMachine.destroyedPoint(pointHit);
                    return;
                }
            }
        }
        board.markBoard(pointHit, "E");

    }

    public void superimposeShip(Board board,Ship ship){
        try{
            for (Point point : ship.getPositionShips()) {
                if (board.getMatriz()[point.X][point.Y].equals("N")) {
                    throw new InvalidCoordinateException("Um navio ja esta posicionado neste local");

                } else if (board.getMatriz()[point.X][point.Y].equals("X")) {
                    throw new InvalidCoordinateException("Essa área pertence a um navio proximo");
                }
            }

        }catch (IndexOutOfBoundsException e){
            throw new NullPointerException("Campo selecionado está fora do tabuleiro");
        }
    }

    public boolean NotIsSequencial(Ship ship) {
        boolean xEquals = ship.getXPoints().stream().allMatch(n -> n.equals(ship.getXPoints().get(0)));

        if (xEquals) { //Garante posições sequenciais na vertical
            for (int i = 1; i < ship.getXPoints().size(); i++) {
                if (!(ship.getYPoints().get(i) == ship.getYPoints().get(i - 1) + 1)){ // se não for sequencial
                    return true;

                }
            }
        }

        boolean yEquals = ship.getYPoints().stream().allMatch(n -> n.equals(ship.getYPoints().get(0)));

        if(yEquals){
            for (int i = 1; i < ship.getYPoints().size(); i++) {
                if (!(ship.getYPoints().get(i) == ship.getYPoints().get(i - 1) + 1)){
                    return true;
                }
            }
        }
        return false;
    }

//    public boolean xIsSequencial(Ship ship) {
//        boolean yEquals = ship.getYPoints().stream().allMatch(n -> n.equals(ship.getYPoints().get(0)));
//
//        if (yEquals) { //Garante posições sequenciais na vertical
//            for (int i = 1; i < ship.getYPoints().size(); i++) {
//                if (ship.getYPoints().get(i) == ship.getYPoints().get(i - 1) + 1 ||
//                    ship.getYPoints().get(i) == ship.getYPoints().get(i - 1) - 1){
//                    return true;
//                }
//            }
//            return false;
//        }
//        return false;
//    }


    public void offLimits(Board board, Ship ship){
        int index = 0;

        while(index < ship.getPositionShips().size()){
            Point point = ship.getPositionShips().get(index);

            for(int xLine = -1; xLine <= 1; xLine++){
                for (int yLine = -1; yLine <= 1 ; yLine++){
                    int newLine = point.X + xLine;
                    int newColumn = point.Y + yLine;

                    if(board.getMatriz()[newLine + 1][newColumn].equals("N") ||
                       board.getMatriz()[newLine][newColumn + 1].equals("N")){
                        throw new InvalidCoordinateException("Os navios estão muito próximos! Posicione a um bloco de distância.");
                    }
                    board.getMatriz()[newLine][newColumn] = "P";

                }
            }
            index++;
        }
    }


}



