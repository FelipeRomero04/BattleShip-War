package org.example.GameEngine;

import org.example.Entitys.Board;
import org.example.Entitys.PlayerDTO;
import org.example.Entitys.Point;
import org.example.Entitys.Ship;
import org.example.Rules.ShipRules;
import org.example.ViewShip.CreatingShip;

import java.util.List;

public class Engine {
    CreatingShip creatingShip;
    ShipRules shipRules;
    //Pensar em como vou inicializar tudo da melhor forma

    public boolean playerWin(PlayerDTO player, PlayerDTO machine){
        if(player.getMyShips().isEmpty()){
            return false;
        }
        return machine.getMyShips().isEmpty();
    }


//    public void formingFleet(Board board){  //Formando frota
////        List<Ship> ships = creatingShip.createShip(); // vai ser uma lista
//        for(Ship ship : ships){
//            shipRules.superimposeShip();
//            if(!shipRules.isSequencial()){
//                throw new RuntimeException("Os navio devem ser posicionados sequencialmente, na horizontal ou vertical.");
//            }
//        }
//
//    }
//Player2 simula a maquina

//    public void positioningInBoard(Ship ship){
//        List<Point> point =
//
//    }

}
