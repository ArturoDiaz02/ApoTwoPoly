package threads;

import objects.Board;
import objects.CommunSquare;

public class Commun extends Thread{

    private Board board;
    

    public Commun(Board board) {
        this.board = board;

    }

    @Override
    public void run(){

        int turn = board.getTurn();
        int position = board.getPlayers().get(turn).getPosition();


        for(CommunSquare square : board.getCommunSquare().toArray()){
            if(square.getNumSquare() == position){
                squareCommuns(square);
                break;
            }
        }

        
    }

    public void squareCommuns(CommunSquare square){
        
    }


}
