package org.example.machineInfra.engine;

import org.example.Entitys.*;

import java.util.Random;

public class SearchEngine {
    private final Random random = new Random();

    private int maxAxleX;
    private int minAxleX = 0;

    private int randomAxleX = 0;
    private int randomAxleY = 0;

    private int maxAxleY;
    private int minAxleY = 0;


    public SearchEngine(Board board){
        this.maxAxleX = board.getWidth();
        this.maxAxleY = board.getHeight();

    }

    public Point searchShip(Point point){
        if(this.randomAxleX != point.X){
            this.randomAxleX = random.nextInt(minAxleX, maxAxleX);
        }

        if(this.randomAxleY != point.Y) {
            this.randomAxleY = random.nextInt(minAxleY, maxAxleY);
        }

        feedback(new Point(randomAxleX, randomAxleY), point);

        return new Point(randomAxleX, randomAxleY);

    }



    private void feedback(Point randomPoint, Point pointTarget){
        if(randomPoint.X > pointTarget.X){
            maxAxleX = randomPoint.X;
        } else if (randomPoint.X < pointTarget.X) {
            minAxleX = randomPoint.X;
        }

        if(randomPoint.Y > pointTarget.Y){
            maxAxleY = randomPoint.Y;
        } else if (randomPoint.Y < pointTarget.Y) {
            minAxleY = randomPoint.Y;
        }

    }

    public void resetIntervals(Board board){
        this.maxAxleX = board.getWidth();
        this.minAxleX = 0;
        this.maxAxleY = board.getHeight();
        this.minAxleX = 0;
    }
    
}
