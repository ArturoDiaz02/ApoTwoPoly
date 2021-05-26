package model.threads;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javafx.scene.image.Image;
import java.io.File;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.objects.Board;
import model.objects.WildCards;

public class WildCardsThreads extends Thread{

    @FXML private ImageView imageWild;

    private Board board;
    private int index = 0;
    private int turn;
    private int position;
    private Stage localStage;
    

    public WildCardsThreads(Board board) {
        this.board = board;

    }

    @Override
    public void run(){

        int vali = 0;
        turn = board.getTurn();
        position = board.getPlayers().get(turn).getPosition();

        for(WildCards square : board.getWildCardsSquare().toArray()){
            if(square.getNumSquare() == position){
                squareWildCards();
                vali = 1;
                break;
            }

            index++;
        }

        if(vali == 1){
            serializable();
            
        }

    }

    public void squareWildCards(){

        int card = (int) Math.random()*14;

        show(new FXMLLoader(getClass().getResource("screens/pop-up/properties/viewWild.fxml")));

        // true es community y false fortune
        if(board.getWildCardsSquare().get(index).isTypeWildCards()){
            imageWild.setImage(new Image(new File(board.getCommunityServiceCards().get(card).getCard()).toURI().toString()));

        }else{
            imageWild.setImage(new Image(new File(board.getFortuneCards().get(card).getCard()).toURI().toString()));
            
        }

        //ejecutar la accion
        
        
        
    }

    private void show(FXMLLoader fxmlLoader){

        localStage = new Stage();

        try {

            fxmlLoader.setController(this);
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            localStage.setScene(scene);
            localStage.setTitle("ApoTwoPoly");
            localStage.show();

        } catch (Exception e) {}
    
        
        
    }

    public void serializable(){
       
        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data\\Data.txt"));
            oos.writeObject(board);
            oos.close();

        } catch (Exception e) {}
    }

}
