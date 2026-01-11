package org.example.playerInfra.engine;

import org.example.Entitys.*;
import org.example.playerInfra.Rules.RulesPlayer;
import org.example.playerInfra.exceptions.InvalidCoordinateException;
import org.example.playerInfra.view.ViewFleet;

import java.util.List;

public class EnginePlayer {
    private final ViewFleet creatingShip;
    private final RulesPlayer rulesPlayer;

    public EnginePlayer(ViewFleet creatingShip) {
        this.creatingShip = creatingShip;
        this.rulesPlayer = new RulesPlayer();
    }

    public Player formingFleet(Board board) { //Formando frota
        List<Ship> ships = creatingShip.createFleet(board);
        return rulesPlayer.validatingFleet(board, ships);
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
