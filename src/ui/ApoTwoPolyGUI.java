package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApoTwoPolyGUI {

    //**************************************************************************************************************************
    // Object GUI

    private Stage localStage;

    public ApoTwoPolyGUI() {
        localStage = new Stage();
    }

    public void setLocalStage(Stage stage){ this.localStage = stage;}

    //**************************************************************************************************************************
    // Init Screens
    

    @FXML
    public void goTokens(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("screens/game_screens/tokens_scene/selectPlayers.fxml"));
        show(fxmlLoader);

    }

    

    @FXML
    public void goBoard(ActionEvent event) throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("screens/game_screens/board_scene/board.fxml"));
        show(fxmlLoader);

<<<<<<< Updated upstream
=======

    }
    

    @FXML
    public void goAllProperties(ActionEvent event) throws IOException, ClassNotFoundException {
        
        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
       
    }

    @FXML
    public void goDeal(ActionEvent event) throws IOException, ClassNotFoundException {
        
        show(new FXMLLoader(getClass().getResource("screens/pop-up/deal/Deal.fxml")), new Stage());
       
    }

    @FXML
    public void rollDice(ActionEvent event) throws IOException, ClassNotFoundException {
        
        show(new FXMLLoader(getClass().getResource("screens/pop-up/dice/Dice.fxml")), new Stage());
        //threadDice = new Dice(this);
        //threadDice.start();
        
>>>>>>> Stashed changes
    }

    private void show(FXMLLoader fxmlLoader) throws IOException{

        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        localStage.setScene(scene);
        localStage.setTitle("ApoTwoPoly");
        localStage.show();

    }

    //**************************************************************************************************************************
    // leave Screens

    @FXML
    public void mainLeave(ActionEvent event) {

        localStage.close();

    }

	
	
}
