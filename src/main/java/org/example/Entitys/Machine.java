package org.example.Entitys;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Machine {
    private final Board board;
//    private final PlayerDTO player;
    private final List<Ship> machineShips;
    private final Random random = new Random();

//    public Machine(Board board, PlayerDTO player) {
//        this.board = board;
//        this.player = player;
//
//    }

    public Machine(Board board, List<Ship> machineShips){
        this.board = board;
        this.machineShips = machineShips;
    }

    //Fazer atack da maquina, tiro aleatorio. Ao enctrar um navio, os tiros se tornam sequencias
    //ate destrui-lo


//    public List<Integer> cellPerShip(PlayerDTO player){
//        List<Integer> cells = new ArrayList<>();
//        for(Ship ship : player.getMyShips()){
//            cells.add(ship.getPositionShips().size());
//        }
//        return cells;
//    }

    public boolean comparePoint(Point firstPoint, Point secondPoint){
        return firstPoint.X == secondPoint.X && firstPoint.Y == secondPoint.Y;

    }

    public List<Ship> getMachineShips() {
        return machineShips;
    }

    public void setMachineShips(Ship machineShips) {
        this.machineShips.add(machineShips);
    }

    public int dataGenerator(int start, int limit){
        if(start == limit){
            return limit;
        }
        return random.nextInt(start, limit);
    }

    public Ship getRandomShip(){
        return machineShips.get(random.nextInt(0, machineShips.size()));
    }

    public Point getRandomPoint(){
        Ship ship = getRandomShip();
        return ship.getPositionShips().get(random.nextInt(0, ship.getPositionShips().size()));
    }




}


