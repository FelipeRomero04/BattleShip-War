package org.example.Entitys;


import java.util.List;

//public record Point(int X, int Y){
//}

// ver se compensa transformar em class com SET

public class Point{
    public final int X;
    public final int Y;
    private final List<Integer> point;

    public Point(int x, int y) {
        X = x;
        Y = y;
        point = List.of(X, Y);
    }

    public List<Integer> getPoint() {
        return point;
    }
}