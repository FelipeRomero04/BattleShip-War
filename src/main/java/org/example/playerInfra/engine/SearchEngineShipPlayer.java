package org.example.playerInfra.engine;

import org.example.Entitys.PlayerDTO;
import org.example.Entitys.Point;
import org.example.Entitys.Ship;

import java.util.Random;

public class SearchEngineShipPlayer {
    private final Random random = new Random();
    private Ship ship;
    private Point randomPoint;

    public Ship getRandomShip(PlayerDTO player){
        if(this.ship == null){
            NewRandomShip(player);
        }
        return this.ship;
    }
    public Point getPointFromRandomShip(PlayerDTO player) {
        if(randomPoint == null){
            NewRandomShip(player);
            NewRandomPoint();

        }
        return this.randomPoint;
    }

    public void NewRandomPoint(){
        this.randomPoint = ship.getPositionShips().get(random.nextInt(ship.getPositionShips().size()));

    }

    public void NewRandomShip(PlayerDTO player){
        this.ship = player.getMyShips().get(random.nextInt(player.getMyShips().size()));
    }

    //WARNING:  SER NewRandomPoint() for chamado antes de NewRandomShip, vai lançar excessão
    //Preciso que os dois sejam chamados em conjunto, porem isso ira afetar attack em RulesMachine


    public Point machineAttackShip(){
        ship.getPositionShips().remove(randomPoint);
        this.randomPoint = ship.getPositionShips().get(random.nextInt(ship.getPositionShips().size()));
        return randomPoint;
    }

// Comparar os Points
// Se for diferente marca erro no tabuleiro
// Ser for igual remove o point e marca acerto no tabuleiro
// Após os pontos serem iguais, os tiros passam a ser sequenciais,até o ship for destruido
    // Depois o randomPoint tem que gerar outro Point








//    public Point findRandomPoint(){
//        if(this.ship.getPositionShips().isEmpty()){
//            this.ship = player.getMyShips().get(random.nextInt(player.getMyShips().size()));
//        }
//        if(this.randomPoint == null){
//            System.out.println("Entrou aquii");
//            this.randomPoint = ship.getPositionShips().get(random.nextInt(ship.getPositionShips().size()));
//        }
//
//        return randomPoint;
//    }

    public void eliminatedPoint(Point point){
        this.ship.getPositionShips().remove(point);
        System.out.println("Eliminou");

    }


}
