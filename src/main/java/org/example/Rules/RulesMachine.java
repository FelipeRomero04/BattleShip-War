package org.example.Rules;

import org.example.Entitys.*;

import java.util.ArrayList;
import java.util.List;

public class RulesMachine {
    private final Board board;
    private final PlayerDTO player;
    private final Machine machine;

    public RulesMachine(Board board, PlayerDTO playerDTO) {
        this.board = board;
        this.player = playerDTO;
        this.machine = new Machine(board,playerDTO);
    }


    public void positioningRandom(){

        List<Point> points = new ArrayList<>();
        List<Integer> cellNum = machine.cellPerShip(player);
        for (int i = 0; i < cellNum.size() ; i++) {

            int column = machine.randomColumn();
            int line = machine.randomLine();
            int directionRandom = machine.randomDirection();

            for (int j = 0; j < cellNum.get(i); j++) {

                Point point = new Point(line, column);
                points.add(point);

                if(directionRandom == 1){
                    column = decrementOrIncrementColumn(column, cellNum.get(i));
                }

                if(directionRandom == 2){
                    line = decrementOrIncrementLine(line, cellNum.get(i));
                }
            }
            System.out.println(points);
            machine.getMachineShips().add(new Ship(points));
        }


    }

//    public void attackPlayer(PlayerDTO player){
//        int column = machine.randomColumn();
//        int line = machine.randomLine();
//
//        Point point = new Point(line,column);
//        Point attackPoint = new Point();
//
//        for(Ship shipPlayer : player.getMyShips()){
//            if(shipPlayer.getPositionShips().contains(point)){
//               attackPoint = shipPlayer.getPositionShips().get(0);
//               shipPlayer.getPositionShips().remove(attackPoint);
//               break;
//            }
//
//        }
//
//        board.markBoard(attackPoint, "A");
//    }

    //Provalmente refatorar par um modo em que o point seja encontrado
    //Mais facilmente

    public Ship machineAttack(PlayerDTO player){
        int column = machine.randomColumn(0 ,board.getHeight());
        int line = machine.randomLine(0 ,board.getWidth());

        int midColumn = board.getHeight() / 2;
        int midLine = board.getWidth() / 2;
        Point randomPoint = new Point(line,column);

        int i = 0;
        while(true){
            Ship shipPlayer = player.getMyShips().get(i);

            for(Point point : shipPlayer.getPositionShips()){
                if(point.equals(randomPoint)){
                    return shipPlayer;
                }

                if(point.Y > midColumn){
                    column = machine.randomColumn(0, midColumn);
                    continue;
                }

                if(point.Y < midColumn){
                    column = machine.randomColumn(midColumn, board.getHeight());
                }

                if(point.X < mid)
            }


        }

        throw new RuntimeException("");

    }
    //Achar um point e retornar o ship


    private int searchPointY(){
        int start = 0;

        int column = machine.randomColumn(start ,board.getHeight());
        int midColumn = board.getHeight() / 2;

        int i = 0; //Colocar numero aleatorio
        while(true){
            Ship shipPlayer = player.getMyShips().get(i);
            Point point = shipPlayer.getPositionShips().get(i);

            if(column == point.Y){
                return column;
            }

            if(point.Y > midColumn){
                column = machine.randomColumn(0, midColumn);
            }

            if(point.Y < midColumn){
                column = machine.randomColumn(midColumn, board.getHeight());
            }


        }
    }


    private int decrementOrIncrementColumn(int column, int cell){
        if (column + cell >= board.getHeight()) {
            System.out.println(column + cell);
            return column - 1;

        }
        return column + 1;
    }

    private int decrementOrIncrementLine(int line, int cell){
        if (line + cell >= board.getWidth()) {
            System.out.println(line + cell);
            return line - 1;

        }
        return line + 1;
    }


}
