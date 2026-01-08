package org.example.playerInfra.engine;

import org.example.Entitys.*;
import org.example.playerInfra.Rules.Outcome;
import org.example.playerInfra.Rules.RulesPlayer;
import org.example.playerInfra.exceptions.CoordinateIsNotSequencial;
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

    //Pensar em como vou inicializar tudo da melhor forma

    public void verifyVictory(PlayerDTO player, Machine machine){
        if(player.getMyShips().isEmpty()){
            System.out.println(Outcome.PLAYER_WIN);
        }
        else if(machine.getMachineShips().isEmpty()){
            System.out.println(Outcome.MACHINE_WIN);
        }
    }



    public PlayerDTO formingFleet(Board board){ //Formando frota
        List<Ship> ships = creatingShip.createShips(board);

       while(true) {
            try {
                return rulesPlayer.formingFleet(board, ships);
            } catch (InvalidCoordinateException e) {
                System.err.println(e.getMessage());
                System.out.println("Posicione o navio novamente.");
            }
        }

    }


    public Point hitMachine(Board board,Machine machine){
        while(true){
            try {
                Point pointHit = creatingShip.hitPoint(board);
                rulesPlayer.attackingPoint(board, machine, pointHit);
                return pointHit;
            } catch (InvalidCoordinateException e) {
                System.err.println(e.getMessage());
                System.out.println("Posicione o navio novamente!");
            }
        }

    }


}
