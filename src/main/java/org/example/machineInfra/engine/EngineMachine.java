package org.example.machineInfra.engine;

import org.example.Entitys.Board;
import org.example.Entitys.Machine;
import org.example.Entitys.PlayerDTO;
import org.example.machineInfra.rules.RulesMachine;

public class EngineMachine {
    RulesMachine rulesMachine;

    public EngineMachine( RulesMachine rulesMachine) {
        this.rulesMachine = rulesMachine;

    }

    public Machine formingFleet(PlayerDTO player, Board board){
        return rulesMachine.positioningRandom(player, board);

    }

    public void hitPlayer(Board board, PlayerDTO player){
        rulesMachine.attackMachineSequencial(board, player);
    }



}
