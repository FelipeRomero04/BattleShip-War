package org.example.Entitys;

import java.util.List;

public class PlayerDTO {
    private List<Ship> myShips;


    public PlayerDTO(List<Ship> myShips) {
        this.myShips = myShips;
    }

    public PlayerDTO() {
    }

    public List<Ship> getMyShips() {
        return myShips;
    }

    public int totalNumberships(){
        return getMyShips().size();
    }

    public void setMyShips(List<Ship> myShips) {
        this.myShips = myShips;
    }
}
