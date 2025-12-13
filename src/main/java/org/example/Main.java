package org.example;

import org.example.Entitys.*;
import org.example.Rules.ShipRules;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       Board board = new Board(14,14);

       Point p1 = new Point(4,5);
       Point p2 = new Point(5,5);
       Point p3 = new Point(6,5);

       Ship ship = new Ship(List.of(p1, p2, p3));
       ShipRules rules = new ShipRules(board, ship);

       boolean sequencial = rules.isSequencial();
       System.out.println(sequencial);
//       PlayerDTO player = new PlayerDTO(new ArrayList<>(List.of(ship)));
//       Point pAttack = new Point(4, 5);
//       Attack attack = new Attack(board,pAttack);
//
//
//
//       attack.hitShip(player, pAttack);
//
//        for(String[] arr : board.getDimensity()){
//            for(String str : arr){
//                System.out.print(str);
//            }
//            System.out.println();
//        }

    }
}

//Legenda:

// ~ -> vazio
// O -> navio
// X -> proibido

//Modo sem validação, chamar putShip depois da area de segurança ser feita