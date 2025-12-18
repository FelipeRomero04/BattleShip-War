package org.example.Entitys;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Machine {
    private final Board board;
    private final PlayerDTO player;
    private List<Ship> machineShips;
    private final Random random = new Random();

    public Machine(Board board, PlayerDTO player) {
        this.board = board;
        this.player = player;

    }
    //Fazer atack da maquina, tiro aleatorio. Ao enctrar um navio, os tiros se tornam sequencias
    //ate destrui-lo


    public List<Integer> cellPerShip(PlayerDTO player){
        List<Integer> cells = new ArrayList<>();
        for(Ship ship : player.getMyShips()){
            cells.add(ship.getPositionShips().size());
        }
        return cells;
    }

    public List<Ship> getMachineShips() {
        return machineShips;
    }

    public int randomLine(int start,int limit){
        return random.nextInt(start, limit);
    }

    public int randomColumn(int start,int limit){
        return random.nextInt(start, limit);
    }

    public int randomDirection(){
        return random.nextInt(1, 3);
    }

    public List<Point> positioningRandom(Board board, PlayerDTO player){

        List<Point> points = new ArrayList<>();
        List<Integer> cellNum = cellPerShip(player);
        for (int i = 0; i < cellNum.size() ; i++) {

            int column = random.nextInt(0, board.getHeight());
            int line = random.nextInt(0, board.getWidth());
            int directionRandom = random.nextInt(1, 3);

            for (int j = 0; j < cellNum.get(i); j++) {

                Point point = new Point(line, column);
                points.add(point);

                if(directionRandom == 1){
                    column = decrementOrIncrementColumn(column, cellNum.get(i));
                }

                if(directionRandom == 2){
                    line = decrementOrIncrementLine(line, cellNum.get(i));
                }
            }
            System.out.println(points);
            this.machineShips.add(new Ship(points));
        }
        return points;

    } //tentar reduzir isso

    private int decrementOrIncrementColumn(int column, int cell){
        if (column + cell >= board.getHeight()) {
            System.out.println(column + cell);
            return column - 1;

        }
        return column + 1;
    }

    private int decrementOrIncrementLine(int line, int cell){
        if (line + cell >= board.getWidth()) {
            System.out.println(line + cell);
            return line - 1;

        }
        return line + 1;
    }

}


