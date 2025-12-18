package org.example.GameEngine;

import org.example.Entitys.*;
import org.example.Rules.RulesMachine;
import org.example.Rules.ShipRules;
import org.example.ViewShip.CreatingShip;

import java.util.List;

public class Engine {
    Board board;
    CreatingShip creatingShip = new CreatingShip();
    RulesMachine rulesMachine;
    ShipRules shipRules; // vai sair e virar o validations(eu acho) static?
    //Aqui vai ser o controller




    public Engine(Board board) {
        this.board = board;
        this.shipRules = new ShipRules(board);
    }

    //Pensar em como vou inicializar tudo da melhor forma

    public boolean playerWin(PlayerDTO player, PlayerDTO machine){
        if(player.getMyShips().isEmpty()){
            return false;
        }
        return machine.getMyShips().isEmpty();
    }


    public void formingFleet(Board board, PlayerDTO player){  //Formando frota
        List<Ship> ships = creatingShip.createShips(board); // vai ser uma lista
        for(Ship ship : ships){
            shipRules.superimposeShip(ship);
            if(!shipRules.xIsSequencial(ship) && !shipRules.yIsSequencial(ship)){
                throw new RuntimeException("Os navio devem ser posicionados sequencialmente, na horizontal ou vertical.");
            }
            shipRules.offLimits(ship);
        }
        player.setMyShips(ships);
    }// Metodo fere o principio SRP, valida e adiciona o jogador


    public void hitPlayer(PlayerDTO player){
//        PlayerDTO player = creatingShip.createShips(board);
        Ship shipAttacked = rulesMachine.attackPlayer(player);
        for (Point point : shipAttacked.getPositionShips()) {
            board.markBoard(point, "A");
        }

        player.getMyShips().remove(shipAttacked);
    }

    public void hitMachine(Machine machine){

    }


}
