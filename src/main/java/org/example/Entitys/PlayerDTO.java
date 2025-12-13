package org.example.Entitys;

import java.util.List;

public class PlayerDTO {
    private final List<Ship> myShips;

    public PlayerDTO(List<Ship> myShips) {
        this.myShips = myShips;
    }

    public List<Ship> getMyShips() {
        return myShips;
    }
}
