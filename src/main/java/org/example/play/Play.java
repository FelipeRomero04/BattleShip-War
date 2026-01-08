package org.example.play;

import org.example.Entitys.Board;
import org.example.Entitys.Machine;
import org.example.Entitys.PlayerDTO;
import org.example.Entitys.Point;
import org.example.playerInfra.engine.EnginePlayer;
import org.example.machineInfra.engine.EngineMachine;
import org.example.machineInfra.rules.RulesMachine;
import org.example.machineInfra.engine.SearchEngine;
import org.example.playerInfra.engine.SearchEngineShipPlayer;
import org.example.playerInfra.view.CreatingShip;

public class Play {
    private final Board boardPlayer;
    private final Board boardMachine;
    private final CreatingShip creatingShip;
    private RulesMachine rulesMachine;
    private final EnginePlayer enginePlayer;
    private final EngineMachine engineMachine;
//    private final RulesMachine rulesMachine;
//    private final RulesPlayer rulePlayer;

    public Play() {
        this.boardPlayer = new Board(14, 14);
        this.boardMachine = new Board(14, 14);
        this.creatingShip = new CreatingShip();
        this.rulesMachine = new RulesMachine(new SearchEngine(boardPlayer), new SearchEngineShipPlayer());
        this.enginePlayer = new EnginePlayer(creatingShip);
        this.engineMachine = new EngineMachine(rulesMachine);


    }

    public void startGame() {

        System.out.println("=".repeat(40));
        System.out.println("BEM-VINDO AO BattleShip: FORME SUA FROTA!");
        System.out.println("=".repeat(40));

        PlayerDTO player = enginePlayer.formingFleet(boardPlayer);
        Machine machine = engineMachine.formingFleet(player, boardMachine);

        while(true){

            enginePlayer.verifyVictory(player, machine);

            System.out.println("=".repeat(30));
            System.out.println("Sua vez! Ataque o návio inimigo.");
            System.out.println("=".repeat(30));

            boardMachine.printBoard();
            Point pointHit = enginePlayer.hitMachine(boardMachine, machine);
            if(boardMachine.getMatriz()[pointHit.X][pointHit.Y].equals("X")){
                System.out.println("Alvo Atingido!");
            }

            System.out.println("=".repeat(30));
            System.out.println("Vez do inimigo!");
            System.out.println("=".repeat(30));

            engineMachine.hitPlayer(boardPlayer, player);
            boardPlayer.printBoard();

            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }



}
