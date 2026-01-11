package org.example.Entitys;

import java.util.List;

public class Player {
    private final List<Ship> myShips;

    public Player(List<Ship> myShips) {
        this.myShips = myShips;
    }


    public List<Ship> getMyShips() {
        return myShips;
    }
}
