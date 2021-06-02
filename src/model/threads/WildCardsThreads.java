package threads;

import java.io.IOException;

import javafx.application.Platform;
import objects.Board;
import objects.WildCards;
import ui.ApoTwoPolyGUI;

public class WildCardsThreads extends Thread{

    private Board board;
    private ApoTwoPolyGUI gui;
    private int index = 0;
    private WildCards wildCards;

    public WildCardsThreads(Board board, ApoTwoPolyGUI gui) {
        this.board = board;
        this.gui = gui;


    }

    @Override
    public void run(){

        wildCards = new WildCards();

        int card = (int) (Math.random()*14) + 1;
      
        for(WildCards square : board.getWildCardsSquare().toArray()){
            if(square.getNumSquare() == board.getPlayers().get(board.getTurn()).getPosition()){

                if(board.getWildCardsSquare().get(index).isTypeWildCards()){

                    Platform.runLater(new Thread(){
                        @Override
                        public void run() {

                            try {
                                gui.actionCommunityCard(wildCards.communityService(board, card));

                            } catch (IOException e) {
                                e.printStackTrace();

                            }
                        }
            
                    });

                }else{

                    Platform.runLater(new Thread(){
                        @Override
                        public void run() {

                            try {
                                gui.actionFortuneCard(wildCards.fortuneCard(board, card));

                            } catch (IOException e) {
                                e.printStackTrace();
                                
                            }
                        }
            
                    });

                }
                
                break;
            }

            index++;
        }

        
    }


}
