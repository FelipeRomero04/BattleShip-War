package org.example.Entitys;

public class Attack {
    private final Board board;


    public Attack(Board board, Point point) {
        this.board = board;

    }

    public Attack(Board board){
        this.board = board;
    }

    public void pointAttacked(Point point){
        board.getDimensity()[point.X][point.Y] = "X";
    }

    public void hitShip(PlayerDTO player, Point point){
        for (int i = 0; i < player.getMyShips().size(); i++) {
            Ship shipPlayer = player.getMyShips().get(i);
            if(shipPlayer.getPositionShips().get(i).X == point.X &&
            shipPlayer.getPositionShips().get(i).Y == point.Y){
                pointAttacked(point);
                player.getMyShips().remove(i);
                return;
            }
        }
        board.getDimensity()[point.X][point.Y] = "E";
    }
}
//Talvez retornar um boolean para no Controller criar a condição de vitória,
//se for true, remover o ship e se a List for empty jogador perdeu

// !REFATORAR -> pointAttacked somente muda o sinal do tabuleiro,
// mas hitShip tambem faz isso, e ainda remove valores da lista