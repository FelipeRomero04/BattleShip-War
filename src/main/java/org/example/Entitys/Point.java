package org.example.Entitys;


import java.util.List;
import java.util.Objects;

public class Point{
    public int X;
    public int Y;
    private final List<Integer> points;

    public Point(int x, int y) {
        X = x;
        Y = y;
        points = List.of(X, Y);
    }

    public List<Integer> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Point)) return false;

        if(this == o) return true;

        Point point = (Point) o;
        return this.X == point.X && this.Y == point.Y;

    }

    @Override
    public int hashCode(){
        return Objects.hash(X, Y);
    }

}