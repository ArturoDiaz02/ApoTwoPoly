package ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	private ApoTwoPolyGUI gui;

    public Main() {
		this.gui = new ApoTwoPolyGUI();
	}

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("screens/main_screen/main.fxml"));//screens/game_screens/board_scene/board.fxml
        fxmlLoader.setController(gui);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ApoTwoPoly");
        stage.show();
		gui.setLocalStage(stage);
        //
    }

    @Override
    public void init(){

        
    }


}
