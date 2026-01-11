package org.example.Entitys;

import java.util.List;

public class Machine {
    private final Board board;
    private final List<Ship> machineShips;


    public Machine(Board board, List<Ship> machineShips){
        this.board = board;
        this.machineShips = machineShips;
    }


    public List<Ship> getMachineShips() {
        return machineShips;
    }

}


