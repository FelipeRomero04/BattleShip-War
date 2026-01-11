package org.example.playerInfra.Rules;

import org.example.Entitys.*;
import org.example.playerInfra.exceptions.CoordinateIsNotSequencial;

import java.util.List;

public class RulesPlayer {

    public Player validatingFleet(Board board, List<Ship> ships){  //Formando frota
        for(Ship ship : ships){
            if(NotIsSequencial(ship)){
                throw new CoordinateIsNotSequencial("Os navio devem ser posicionados sequencialmente, na horizontal ou vertical.");
            }
            offLimits(board, ship);
        }
        return new Player(ships);
    }

    public void attackingPoint(Board board,Machine machine, Point pointHit){

        for (Ship shipMachine : machine.getMachineShips()){
            for (Point pointShip : shipMachine.getPositionShips()){
                if(pointShip.equals(pointHit)){
                    board.markBoard(pointHit, "X");
                    System.out.println("Alvo ");
                    shipMachine.getPositionShips().remove(pointHit);

                    if(shipMachine.getPositionShips().isEmpty()){
                        machine.getMachineShips().remove(shipMachine);
                    }

                    return;
                }

            }
        }
        board.markBoard(pointHit, "E");

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
                if (!(ship.getXPoints().get(i) == ship.getXPoints().get(i - 1) + 1)){
                    System.out.println(ship.getYPoints().get(i));
                    System.out.println(ship.getYPoints().get(i - 1) + 1);
                    return true;
                }
            }
        }
        return false;
    }


    public void offLimits(Board board, Ship ship){
        int index = 0;

        while(index < ship.getPositionShips().size()){
            Point point = ship.getPositionShips().get(index);

            for(int xLine = -1; xLine <= 1; xLine++){
                for (int yLine = -1; yLine <= 1 ; yLine++){
                    int newLine = point.X + xLine;
                    int newColumn = point.Y + yLine;

                    Point aroundPoint =  new Point(newLine, newColumn);

                    if(board.getCoordinate(aroundPoint).equals("N")) {
                        if (!ship.getPositionShips().contains(aroundPoint)){
                            throw new CoordinateIsNotSequencial("Navios posicionados muito próximos. Eles devem conter no mínimo um ponto de distância");
                        }
                    }

                    if(!board.getCoordinate(aroundPoint).equals("N")){
                        board.setCoordinate(aroundPoint, "P");
                    }
                }
            }
            index++;
        }
    }


}

