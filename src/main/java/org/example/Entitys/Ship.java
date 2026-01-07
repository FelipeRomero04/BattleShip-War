package org.example.Entitys;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private Board board;
    private List<Point> positionShips;
    // K -> num de células / V -> list de posição

    public Ship(Board board) {
        this.board = board;
    }

    public Ship(List<Point> ships) {
        this.positionShips = ships;
    }

    public void creatingShip(List<Point> points){
        this.positionShips = points;
    }

    public void putShip(){
        for (Point point : this.positionShips){
            this.board.markBoard(point, "~");
        }
    }

    public Board getBoard() {
        return board;
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

    public void destroyedPoint(Point point){
        positionShips.remove(point);
    }



}
