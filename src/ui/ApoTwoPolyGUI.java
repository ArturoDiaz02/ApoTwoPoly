package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.data_structure.MeLinkedLists;
import model.objects.Board;
import model.objects.Player;
import model.threads.Dice;

public class ApoTwoPolyGUI {

    @FXML private Pane paneBoat;
    @FXML private Pane paneBox;
    @FXML private Pane paneCar;
    @FXML private Pane paneCat;
    @FXML private Pane paneDog;
    @FXML private Pane paneHat;
    @FXML private Pane paneHole;
    @FXML private Pane paneShoes;
    @FXML private CheckBox checkBoat;
    @FXML private CheckBox checkBox;
    @FXML private CheckBox checkCar;
    @FXML private CheckBox checkCat;
    @FXML private CheckBox checkDog;
    @FXML private CheckBox checkHat;
    @FXML private CheckBox checkHole;
    @FXML private CheckBox checkShoes;
    @FXML private ImageView tokenHat;
    @FXML private ImageView tokenShoes;
    @FXML private ImageView tokenHole;
    @FXML private ImageView tokenBox;
    @FXML private ImageView tokenCar;
    @FXML private ImageView tokenBoat;
    @FXML private ImageView tokenDog;
    @FXML private ImageView tokenCat;

    //**************************************************************************************************************************
    // Object GUI

    private final int TOTALMONEY = 1500;
    private Stage localStage;
    private Board board;
    private Dice threadDice;

    public ApoTwoPolyGUI(Board board) {
        localStage = new Stage();
        this.board = board;
    }

    public void setLocalStage(Stage stage){ this.localStage = stage;}

    //**************************************************************************************************************************
    // Init Screens
    

    @FXML
    public void goTokens(ActionEvent event) throws IOException {

        show(new FXMLLoader(getClass().getResource("screens/game_screens/tokens_scene/selectPlayers.fxml")));

    }

    @FXML
    public void goBoard(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/game_screens/board_scene/board.fxml")));

        if(checkBoat.isSelected()){
            paneBoat.setDisable(false);
            board.getPlayers().add(new Player(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>(), TOTALMONEY));
            tokenBoat.setImage(new Image("tokens/boat.png"));
        }
        
        if(checkBox.isSelected()){
            paneBox.setDisable(false);
            board.getPlayers().add(new Player(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>(), TOTALMONEY));
            tokenBox.setImage(new Image("tokens/box.png"));
        }

        if(checkCar.isSelected()){
            paneCar.setDisable(false);
            board.getPlayers().add(new Player(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>(), TOTALMONEY));
            tokenCar.setImage(new Image("tokens/car.png"));
        }

        if(checkCat.isSelected()){
            paneCat.setDisable(false);
            board.getPlayers().add(new Player(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>(), TOTALMONEY));
            tokenCat.setImage(new Image("tokens/cat.png"));
        }

        if(checkDog.isSelected()){
            paneDog.setDisable(false);
            board.getPlayers().add(new Player(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>(), TOTALMONEY));
            tokenDog.setImage(new Image("tokens/dog.png"));
        }

        if(checkHat.isSelected()){
            paneHat.setDisable(false);
            board.getPlayers().add(new Player(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>(), TOTALMONEY));
            tokenHat.setImage(new Image("tokens/hat.png"));
        }

        if(checkHole.isSelected()){
            paneHole.setDisable(false);
            board.getPlayers().add(new Player(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>(), TOTALMONEY));
            tokenHole.setImage(new Image("tokens/hole.png"));
        }

        if(checkShoes.isSelected()){
            paneShoes.setDisable(false);
            board.getPlayers().add(new Player(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>(), TOTALMONEY));
            tokenShoes.setImage(new Image("tokens/shoes.png"));
        }


    }

    @FXML
    public void rollDice(ActionEvent event) throws IOException {

        threadDice = new Dice(board);
        threadDice.start();

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

    //**************************************************************************************************************************
    // Methods

    
	
	
}
