package ui;

//import java.io.FileInputStream;
import java.io.IOException;
//import java.io.ObjectInputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import data_structure.MeLinkedLists;
import objects.Board;
import objects.Player;

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
    @FXML private ImageView dice1;
    @FXML private ImageView dice2;
    @FXML private Label numDice;

    //**************************************************************************************************************************
    // Object GUI

    private final int TOTALMONEY = 1500;
    private final int TRY = 6;
    private Stage localStage;
    private Board board;

    public ApoTwoPolyGUI(Board board) {
        localStage = new Stage();
        this.board = board;
    }

    public ApoTwoPolyGUI() {
        localStage = new Stage();
        this.board = new Board();
    }

    public void setBoard(Board board){ this.board = board;}
    public void setLocalStage(Stage stage){ this.localStage = stage;}

    //**************************************************************************************************************************
    // Init Screens
    

    @FXML
    public void goTokens(ActionEvent event) throws IOException {
        mainLeave(event);
        show(new FXMLLoader(getClass().getResource("screens/game_screens/tokens_scene/selectPlayers.fxml")), new Stage());

    }

    @FXML
    public void goBoard(ActionEvent event) throws IOException{
        
        mainLeave(event);
        show(new FXMLLoader(getClass().getResource("screens/game_screens/board_scene/board.fxml")), new Stage());
        alert("INFORMACION", "Con las teclas W,A,S,D el jugador en turno puede mover su token sobre el tablero, cuando desee terminar su turno preciose la tecla ENTER");


        if(checkBoat.isSelected()){
            paneBoat.setDisable(false);
            tokenBoat.setVisible(true);
            board.getPlayers().add(new Player(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>(), TOTALMONEY, tokenBoat, "BOAT"));
            
        }
        
        if(checkBox.isSelected()){
            paneBox.setDisable(false);
            tokenBox.setVisible(true);
            board.getPlayers().add(new Player(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>(), TOTALMONEY, tokenBox, "BOX"));
            
        }

        if(checkCar.isSelected()){
            paneCar.setDisable(false);
            tokenCar.setVisible(true);
            board.getPlayers().add(new Player(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>(), TOTALMONEY, tokenCar, "CAR"));
            
        }

        if(checkCat.isSelected()){
            paneCat.setDisable(false);
            tokenCat.setVisible(true);
            board.getPlayers().add(new Player(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>(), TOTALMONEY, tokenCat, "CAT"));
            
        }

        if(checkDog.isSelected()){
            paneDog.setDisable(false);
            tokenDog.setVisible(true);
            board.getPlayers().add(new Player(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>(), TOTALMONEY, tokenDog, "DOG"));
            
        }

        if(checkHat.isSelected()){
            paneHat.setDisable(false);
            tokenHat.setVisible(true);
            board.getPlayers().add(new Player(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>(), TOTALMONEY, tokenHat, "HAT"));
            
        }

        if(checkHole.isSelected()){
            paneHole.setDisable(false);
            tokenHole.setVisible(true);
            board.getPlayers().add(new Player(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>(), TOTALMONEY, tokenHole, "HOLE"));
            
        }

        if(checkShoes.isSelected()){
            paneShoes.setDisable(false);
            tokenShoes.setVisible(true);
            board.getPlayers().add(new Player(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>(), TOTALMONEY, tokenShoes, "SHOES"));
            
        }


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
         
    }

    private void show(FXMLLoader fxmlLoader, Stage stage) throws IOException{

        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ApoTwoPoly");
        stage.show();
        localStage = stage;

    }

    //**************************************************************************************************************************
    // leave Screens

    @FXML
    public void mainLeave(ActionEvent event) {

        localStage.close();

    }

    //**************************************************************************************************************************
    // Methods

    @FXML
    public void moveToken(KeyEvent event) throws ClassNotFoundException, IOException {
        switch (board.getPlayers().get(board.getTurn()).getNameToken()) {
            case "BOAT":
                tokenBoat = board.getPlayers().get(board.getTurn()).moveUp(event.getCode());
                break;
        
            case "BOX":
                tokenBox = board.getPlayers().get(board.getTurn()).moveUp(event.getCode());
                break;

            case "CAR":
                tokenCar = board.getPlayers().get(board.getTurn()).moveUp(event.getCode());
                break;

            case "CAT":
                tokenCat = board.getPlayers().get(board.getTurn()).moveUp(event.getCode());
                break;

            case "DOG":
                tokenDog = board.getPlayers().get(board.getTurn()).moveUp(event.getCode());
                break;

            case "HAT":
                tokenHat = board.getPlayers().get(board.getTurn()).moveUp(event.getCode());
                break;

            case "HOLE":
                tokenHole = board.getPlayers().get(board.getTurn()).moveUp(event.getCode());
                break;

            case "SHOES":
                tokenShoes = board.getPlayers().get(board.getTurn()).moveUp(event.getCode());
                break;
        }

        if(event.getCode() == KeyCode.ENTER){
           /* threadCommun = new Commun(board);
            threadProperties = new PropertiesThreads(board);
            threadWildCards = new WildCardsThreads(board);
            threadCommun.start();
            threadProperties.start();
            threadWildCards.start();*/

            board.setTurn(board.getTurn() + 1);

            if(board.getTurn() == board.getPlayers().size()){
                board.setTurn(0);
            }


            /*ObjectInputStream ois= new ObjectInputStream(new FileInputStream("data\\Data.txt"));
            board = (Board) ois.readObject();
            ois.close();*/

        }

    }

    public Board initDice() throws IOException {

        int diceOne = 0;
        int diceTwo = 0;

        for(int i = 0; i < TRY; i++){

            diceOne = (int) (Math.random()*5)+1;
            diceTwo = (int) (Math.random()*5)+1;

            System.out.println(diceOne + " " + diceTwo);
    
            dice1.setImage(new Image(dice(diceOne)));
            dice2.setImage(new Image(dice(diceTwo)));

            

        }

        numDice.setText(String.valueOf(diceOne + diceTwo));

        board.getPlayers().get(board.getTurn()).setPosition(board.getPlayers().get(board.getTurn()).getPosition() + diceOne + diceTwo);

        return board;

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

    public void alert(String title, String mss){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(mss);
        alert.showAndWait();
        
    }
	
	
}
