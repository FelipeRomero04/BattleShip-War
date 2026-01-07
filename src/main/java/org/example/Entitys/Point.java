package org.example.Entitys;


import java.util.List;
import java.util.Objects;

//public record Point(int X, int Y){
//}

// ver se compensa transformar em class com SET

public class Point{
    public int X;
    public int Y;
    private List<Integer> point;

    public Point(int x, int y) {
        X = x;
        Y = y;
        point = List.of(X, Y);
    }

    public List<Integer> getPoint() {
        return point;
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