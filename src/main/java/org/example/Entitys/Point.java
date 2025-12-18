package org.example.Entitys;


import java.util.List;

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

    public Point() {
    }

    public List<Integer> getPoint() {
        return point;
    }
}