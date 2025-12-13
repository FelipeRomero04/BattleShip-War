package org.example.validations;

import org.example.Entitys.Board;
import org.example.Entitys.Point;
import org.example.Entitys.Ship;

import java.util.ArrayList;
import java.util.List;

//public class PositioningValidator {
//    private final Board board;
//    private final List<Integer> xPoints;
//    private final List<Integer> yPoints;
//
//    public PositioningValidator(Board board , List<Point> points) {
//        this.board = board;
//        this.xPoints = new ArrayList<>(points.stream().map(Point::X).sorted().toList());
//        this.yPoints = new ArrayList<>(points.stream().map(Point::Y).sorted().toList());
//    }
//
//    public void superimposeShip(Ship ship){
//        try{
//            for (Point point : ship.getPositionShips()) {
//                if (board.getDimensity()[point.X()][point.Y()].equals("O")) {
//                    throw new IllegalArgumentException("Um navio ja esta posicionado neste local");
//
//                } else if (board.getDimensity()[point.X()][point.Y()].equals("X")) {
//                    throw new IllegalArgumentException("Essa área pertence a um navio proximo");
//                }
//            }
//
//        }catch (IndexOutOfBoundsException e){
//            throw new NullPointerException("Campo selecionado está fora do tabuleiro");
//        }
//    }
//
//
//    public boolean isSequencial() {
//        boolean xEquals = xPoints.stream().allMatch(n -> n.equals(xPoints.get(0)));
//        boolean yEquals = yPoints.stream().allMatch(n -> n.equals(yPoints.get(0)));
//
//        if (xEquals) { //Garante posições sequenciais na vertical
//            for (int i = 1; i < this.xPoints.size(); i++) {
//                if (yPoints.get(i) == yPoints.get(i - 1) + 1) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        if (yEquals) { //Garante posições sequenciais na horizontal
//            for (int i = 1; i < this.yPoints.size(); i++) {
//                if (xPoints.get(i) == xPoints.get(i - 1) + 1) {
//                    return true;
//                }
//            }
//            return false;
//        }
//        return false;
//        //Mantar aqui ou para PositionShip?
//    }
//
//
//
//    public void offLimits(List<Point> pointsShip){
//        int index = 0;
//
//        while(index < pointsShip.size()){
//            Point point = pointsShip.get(index);
//
//            for(int xLine = -1; xLine <= 1; xLine++){
//                for (int yLine = -1; yLine <= 1 ; yLine++){
//                    int newLine = point.X() + xLine;
//                    int newColumn = point.Y() + yLine;
//
//                    board.getDimensity()[newLine][newColumn] = "O";
//                }
//            }
//            index++;
//        }
//    }
////ARRUMAR ESSAS CLASSES URGENTEMENTE
//
//}
