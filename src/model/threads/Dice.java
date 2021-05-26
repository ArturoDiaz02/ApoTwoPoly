package model.threads;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import model.objects.Board;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class Dice extends Thread{

    @FXML private ImageView dice1;
    @FXML private ImageView dice2;
    @FXML private Label numDice;

    private Stage localStage;
    private final int TRY = 6;
    private final long SLEEP = 1000;
    private Board board;
    
    public Dice(Board board) {
        this.board = board;

    }
    
    @Override
    public void run(){
        show(new FXMLLoader(getClass().getResource("screens/pop-up/dice/Dice.fxml")));

        int diceOne = 0;
        int diceTwo = 0;

        for(int i = 0; i < TRY; i++){

            diceOne = (int) (Math.random()*6)*1;
            diceTwo = (int) (Math.random()*6)*1;

            dice1.setImage(new Image(dice(diceOne)));
            dice2.setImage(new Image(dice(diceTwo)));


        }

        numDice.setText(String.valueOf(diceOne + diceTwo));

        board.getPlayers().get(board.getTurn()).setPosition(board.getPlayers().get(board.getTurn()).getPosition() + diceOne + diceTwo);

        serializable();

        try {
            Thread.sleep(SLEEP);
            
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        localStage.close();

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

        } catch (Exception e) {
            
        }
    
        
    }

    private String dice(int value){

        switch (value) {
           case 1:
                return "de1.jpg";
        
            case 2:
                return "de2.jpg";
              
            case 3:
                return "de3.jpg";
             
            case 4:
                return "de4.jpg";
              
            case 5:
                return "de5.jpg";
              
            case 6:
                return "de6.jpg";
             
            default:
                return "de1.jpg";
             
        }
       
      
        
    }

    public void serializable(){
       
        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data\\Data.txt"));
            oos.writeObject(board);
            oos.close();

        } catch (Exception e) {}
    }


}
