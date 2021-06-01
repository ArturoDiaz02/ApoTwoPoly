package threads;

import objects.Board;
import objects.CommunityServiceCards;
import objects.FortuneCards;
import objects.WildCards;

public class WildCardsThreads extends Thread{

    private Board board;
    private int index = 0;
    private int turn;
    private int position;
    private WildCards wildCards;
    private CommunityServiceCards communityServiceCards;
    private FortuneCards fortuneCards;


    public WildCardsThreads(Board board) {
        this.board = board;

    }

    @Override
    public void run(){

        wildCards = new WildCards();
        communityServiceCards = new CommunityServiceCards();
        fortuneCards = new FortuneCards();

        int card = (int) Math.random()*14;
      
        for(WildCards square : board.getWildCardsSquare().toArray()){
            if(square.getNumSquare() == board.getPlayers().get(board.getTurn()).getPosition()){

                if(board.getWildCardsSquare().get(index).isTypeWildCards()){

                    communityServiceCards = wildCards.communityService(board, card);

                }else{
                    fortuneCards = wildCards.fortuneCard(board, card);
                    
                }
                
                break;
            }

            index++;
        }

        /*Platform.runLater(new Thread(){
            @Override
            public void run() {
                gui.setBoard(axBoard);
            }

        });*/

    }


}
