package org.example.Entitys;

import java.util.List;

public class Machine {
    private Board board;
    private final List<Ship> machineShips;

    public Machine(Board board, List<Ship> machineShips) {
        this.board = board;
        this.machineShips = machineShips;
    }



}

//Numeros de ship
// largura x altura / 2 % 5
