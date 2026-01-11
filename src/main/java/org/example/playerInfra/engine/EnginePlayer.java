package org.example.playerInfra.engine;

import org.example.Entitys.*;
import org.example.playerInfra.Rules.RulesPlayer;
import org.example.playerInfra.exceptions.InvalidCoordinateException;
import org.example.playerInfra.view.CreatingShip;

import java.util.List;

public class EnginePlayer {

    CreatingShip creatingShip;
    RulesPlayer rulesPlayer;

    public EnginePlayer(CreatingShip creatingShip) {
        this.creatingShip = creatingShip;
        this.rulesPlayer = new RulesPlayer();
    }

    public PlayerDTO formingFleet(Board board){ //Formando frota
        boolean resetList = true;
        int attemp = 0;
        int maxAttemp = 3;

       while(attemp < maxAttemp) {
            try {
                List<Ship> ships = creatingShip.createShips(board, resetList);
                System.out.println(ships.size());
                return rulesPlayer.formingFleet(board, ships);
            } catch (InvalidCoordinateException e) {
                resetList = false;
                System.err.println(e.getMessage());
                System.out.println("Posicione o navio novamente.");
            }
            attemp++;
       }
        throw new RuntimeException("Tentativas excedidas.");
    }


    public void hitMachine(Board board,Machine machine){
        while(true){
            try {
                Point pointHit = creatingShip.hitPoint(board);
                rulesPlayer.attackingPoint(board, machine, pointHit);
                return;
               //Ver como isso ta funcionando
            } catch (InvalidCoordinateException e) {
                System.err.println(e.getMessage());
                System.out.println("Posicione o navio novamente!");
            }
        }

    }


}
