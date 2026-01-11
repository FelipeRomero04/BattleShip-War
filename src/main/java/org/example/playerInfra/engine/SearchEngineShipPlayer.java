package org.example.playerInfra.engine;

import org.example.Entitys.Player;
import org.example.Entitys.Point;
import org.example.Entitys.Ship;

import java.util.Random;

public class SearchEngineShipPlayer {
    private final Random random = new Random();
    private Ship ship;
    private Point randomPoint;

    public Ship getRandomShip(Player player){
        if(this.ship == null){
            NewRandomShip(player);
        }
        return this.ship;
    }
    public Point getPointFromRandomShip(Player player) {
        if(randomPoint == null){
            NewRandomShip(player);
            NewRandomPoint();

        }
        return this.randomPoint;
    }

    public void NewRandomPoint(){
        this.randomPoint = ship.getPositionShips().get(random.nextInt(ship.getPositionShips().size()));
    }

    public void NewRandomShip(Player player){
        this.ship = player.getMyShips().get(random.nextInt(player.getMyShips().size()));
    }

}
