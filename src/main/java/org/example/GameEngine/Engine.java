package org.example.GameEngine;

import org.example.Entitys.*;
import org.example.Rules.RulesMachine;
import org.example.Rules.RulesPlayer;
import org.example.ViewShip.CreatingShip;

import java.util.List;

public class Engine {

    CreatingShip creatingShip;
    RulesPlayer rulesPlayer;

    public Engine(CreatingShip creatingShip) {

        this.creatingShip = creatingShip;
        this.rulesPlayer = new RulesPlayer();
    }

    //Pensar em como vou inicializar tudo da melhor forma

    public boolean playerWin(PlayerDTO player, Machine machine){
        return player.getMyShips().isEmpty();
    }//TODO: FAZER ENUM

    public Board creatingBoard(){
        return creatingShip.defineSizeBoard();
    }


    public PlayerDTO formingFleet(Board board){  //Formando frota
        List<Ship> ships = creatingShip.createShips(board);

        // vai ser uma lista
        return rulesPlayer.formingFleet(board,ships);
    }


    public Point hitMachine(Board board,Machine machine){
        Point pointHit = creatingShip.hitPoint();
        rulesPlayer.attackingPoint(board ,machine, pointHit);
        return pointHit;
    }


}
