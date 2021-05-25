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
