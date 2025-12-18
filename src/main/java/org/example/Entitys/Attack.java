package org.example.Entitys;

public class Attack {
    private final Board board;

    public Attack(Board board, Point point) {
        this.board = board;

    }

    public Attack(Board board){
        this.board = board;
    }

    public void playerAttack(Machine machine, Point point){
        for (int i = 0; i < machine.getMachineShips().size(); i++) {
            Ship shipMachine = machine.getMachineShips().get(i);
            if(shipMachine.getPositionShips().get(i).X == point.X &&
            shipMachine.getPositionShips().get(i).Y == point.Y){
                board.markBoard(point, "X");
                machine.getMachineShips().remove(i);
                return;
            }
        }

        board.markBoard(point, "E"); //Errou
    } //Tambem fere SRP
}
//Talvez retornar um boolean para no Controller criar a condição de vitória,
//se for true, remover o ship e se a List for empty jogador perdeu
