package threads;

import java.io.IOException;

import javafx.application.Platform;
import objects.Board;
import objects.CommunSquare;
import ui.ApoTwoPolyGUI;

public class CommunThreads extends Thread{

    private Board board;
    private int index = 0;
    private CommunSquare propertie;
    private ApoTwoPolyGUI gui;
    

    public CommunThreads(Board board, ApoTwoPolyGUI gui) {
        this.board = board;
        this.gui = gui;

    }

    @Override
    public void run(){

        propertie = new CommunSquare();

        for(CommunSquare square : board.getCommunSquare().toArray()){
            
            if(square.getNumSquare() == board.getPlayers().get(board.getTurn()).getPosition()){

                Platform.runLater(new Thread(){
                    @Override
                    public void run() {

                        try {
                            gui.actionCommunSquare(square.communSquare(board, index));

                        } catch (IOException e) {
                            e.printStackTrace();

                        }
                    }
        
                });

                break;
                
            }

            index++;
        }

        
    }


}
