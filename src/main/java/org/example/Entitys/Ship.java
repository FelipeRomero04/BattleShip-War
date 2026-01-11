package org.example.Entitys;


import java.util.List;

public class Ship {
    private Board board;
    private final List<Point> positionShips;

    public Ship(List<Point> ships) {
        this.positionShips = ships;
    }

    public List<Point> getPositionShips() {
        return positionShips;
    }

    public List<Integer> getXPoints(){
        return positionShips.stream().map(p -> p.X).sorted().toList();
    }

    public List<Integer> getYPoints(){
        return positionShips.stream().map(p -> p.Y).sorted().toList();
    }





}
