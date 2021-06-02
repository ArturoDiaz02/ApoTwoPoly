package threads;

import java.io.IOException;

import javafx.application.Platform;
import objects.Board;
import objects.Properties;
import ui.ApoTwoPolyGUI;

public class PropertiesThreads extends Thread{

    private ApoTwoPolyGUI gui;
    private Board board;
    private int index = 0;
    private int turn;
    private int position;
    private Properties propertie;
    

    public PropertiesThreads(Board board,  ApoTwoPolyGUI gui) {
        this.board = board;
        this.gui = gui;

    }

    @Override
    public void run(){

        propertie = new Properties();

        for(Properties square : board.getPropertiesSquare().toArray()){
            
            if(square.getNumSquare() == board.getPlayers().get(board.getTurn()).getPosition()){

                Platform.runLater(new Thread(){
                    @Override
                    public void run() {

                        try {
                            gui.actionProperties(propertie.propeties(board, index));

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
