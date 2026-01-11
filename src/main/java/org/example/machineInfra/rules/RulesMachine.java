package org.example.machineInfra.rules;

import org.example.Entitys.*;
import org.example.machineInfra.engine.SearchEngine;
import org.example.playerInfra.engine.SearchEngineShipPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RulesMachine {
    private final Random random = new Random();
    private final SearchEngine engineMachine;
    private final SearchEngineShipPlayer enginePlayer;

    private boolean sequencial = false;

    public RulesMachine( SearchEngine engine, SearchEngineShipPlayer enginePlayer) {
        this.engineMachine = engine;
        this.enginePlayer = enginePlayer;
    }

    public Machine positioningRandom(Player player, Board board){
        List<Point> points = new ArrayList<>();
        List<Ship> machineShips = new ArrayList<>();
        List<Integer> cellNum = cellPerShip(player);

        for (int i = 0; i < cellNum.size() ; i++) {

            int column = random.nextInt(0, board.getHeight());
            int line = random.nextInt(0, board.getWidth());
            System.out.println(line);
            System.out.println(column);
            int directionRandom = random.nextInt(1,3);

            for (int j = 0; j < cellNum.get(i); j++) {

                Point point = new Point(line, column);
                points.add(point);

                if(directionRandom == 1){
                    column = decrementOrIncrementColumn(board,column, cellNum.get(i));
                }

                if(directionRandom == 2){
                    line = decrementOrIncrementLine(board ,line, cellNum.get(i));
                }
            }
            System.out.println(points);
            machineShips.add(new Ship(points));
        }
        return new Machine(board, machineShips);
    }

    public Point findShipTarget(Board board, Player player){
        if(enginePlayer.getRandomShip(player).getPositionShips().isEmpty()){ //Acabou as posições do ship
           resetSearch(board, player);
        }

        Point targetPoint = enginePlayer.getPointFromRandomShip(player);
        Point foundPoint = engineMachine.searchShip(targetPoint);

        definingAttackMode(player,foundPoint);
        return foundPoint;
    }

    public void attackMachineSequencial(Board board, Player player) {

        Point attackPoint = findShipTarget(board ,player);

        if(!sequencial){
            System.out.println("ENTROU AKI");
            System.out.println("X: " + attackPoint.X + " Y: " + attackPoint.Y);
            board.markBoard(attackPoint, "E");
            return;
        }

        Ship shipRandom = sequencialMode(board, player);

        if(shipRandom.getPositionShips().isEmpty()){
            player.getMyShips().remove(shipRandom);
        }

    }

    private void resetSearch(Board board, Player player){
        enginePlayer.NewRandomShip(player);
        enginePlayer.NewRandomPoint();
        this.sequencial = false;
        engineMachine.resetIntervals(board);
    }

    private void definingAttackMode(Player player, Point point){
        for(Ship shipPlayer : player.getMyShips()){
            if(shipPlayer.getPositionShips().contains(point)){
                this.sequencial = true;
                return;
            }
        }

    }

    private Ship sequencialMode(Board board, Player player){
        Ship shipRandom = enginePlayer.getRandomShip(player);
        Point attackPoint = shipRandom.getPositionShips().get(random.nextInt(shipRandom.getPositionShips().size()));
        System.out.println("X: " + attackPoint.X + " Y: " + attackPoint.Y);

        board.markBoard(attackPoint, "X");
        System.out.println("Seu Navio está sendo bombardeado.");

        shipRandom.getPositionShips().remove(attackPoint);
        return shipRandom;
    }


    private List<Integer> cellPerShip(Player player){
        List<Integer> cells = new ArrayList<>();
        for(Ship ship : player.getMyShips()){
            cells.add(ship.getPositionShips().size());
        }
        return cells;
    }

    private int decrementOrIncrementColumn(Board board,int column, int cell){
        if (column + cell >= board.getHeight()) {
            System.out.println(column + cell);
            return column - 1;

        }
        return column + 1;
    }

    private int decrementOrIncrementLine(Board board ,int line, int cell){
        if (line + cell >= board.getWidth()) {
            System.out.println(line + cell);
            return line - 1;

        }
        return line + 1;
    }
}
