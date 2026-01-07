package org.example.Rules;

import org.example.Entitys.*;
import org.example.Rules.searchEngine.SearchEngine;
import org.example.Rules.searchEngine.SearchEngineShipPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RulesMachine {
    private final Random random = new Random();

    private final SearchEngine engineMachine;
    private final SearchEngineShipPlayer enginePlayer;

    private boolean sequencial = false;


    public RulesMachine( SearchEngine engine, SearchEngineShipPlayer enginePlayer) {
//        this.board = board;
        this.engineMachine = engine;
        this.enginePlayer = enginePlayer;
    }


    public Machine positioningRandom(PlayerDTO player, Board board){
        List<Point> points = new ArrayList<>();
        List<Ship> machineShips = new ArrayList<>();
        List<Integer> cellNum = cellPerShip(player);

        for (int i = 0; i < cellNum.size() ; i++) {

            int column = random.nextInt(0, board.getHeight());
            int line = random.nextInt(0, board.getWidth());
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

//if(player.getShips.size > 1)
    // searchShip, machineAttackSequencial
    public Point findShipTarget(Board board,PlayerDTO player){
        if(enginePlayer.getRandomShip(player).getPositionShips().isEmpty()){ //Acabou as posições do ship
           resetSearch(board, player);
        }

        Point randomPoint = enginePlayer.getPointFromRandomShip(player);
        Point findShip = engineMachine.searchShip(randomPoint);

        definingAttackMode(findShip, randomPoint);
        return findShip;
    }

    public void attackMachineSequencial(Board board, PlayerDTO player) {

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

    private void resetSearch(Board board, PlayerDTO player){
        enginePlayer.NewRandomShip(player);
        enginePlayer.NewRandomPoint();
        this.sequencial = false;
        engineMachine.resetIntervals(board);
    }

    private void definingAttackMode(Point pointPlayer, Point pointMachine){
        if(pointPlayer.equals(pointMachine)){
            System.out.println("Seu navio está sendo atacado! ");
            this.sequencial = true;
        }
    }

    private Ship sequencialMode(Board board,PlayerDTO player){
        Ship shipRandom = enginePlayer.getRandomShip(player);
        Point attackPoint = shipRandom.getPositionShips().get(random.nextInt(shipRandom.getPositionShips().size()));
        System.out.println("X: " + attackPoint.X + " Y: " + attackPoint.Y);

        board.markBoard(attackPoint, "X");
        System.out.println("Seu Navio está sendo bombardeado.");

        shipRandom.getPositionShips().remove(attackPoint);
        return shipRandom;
    }





//    public void attackMachineSequencial(boolean flag) {
//        findShipTarget();
//        Point randomPoint = enginePlayer.getPointFromRandomShip();
//        if(sequencial){
//            Ship shipRandom = enginePlayer.getRandomShip();
//            randomPoint = shipRandom.getPositionShips().get(random.nextInt(shipRandom.getPositionShips().size()));
//            board.markBoard(randomPoint, "X");
//            shipRandom.destroyedPoint(randomPoint);
//
//        }
//
//        board.markBoard(randomPoint, "E");
//
//
//
//    }





    private List<Integer> cellPerShip(PlayerDTO player){
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
