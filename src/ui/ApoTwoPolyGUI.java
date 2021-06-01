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
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import data_structure.MeLinkedLists;
import objects.Board;
import objects.Player;

public class ApoTwoPolyGUI extends AttributesGUI{

    //**************************************************************************************************************************
    // Object GUI

    private final int TOTALMONEY = 1500;
    private final int TRY = 10;
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

        if(!(checkBoat.isSelected()) && !(checkBox.isSelected()) && !(checkCar.isSelected()) && !(checkCat.isSelected()) && !(checkDog.isSelected()) && !(checkHat.isSelected()) && !(checkHole.isSelected()) && !(checkShoes.isSelected())){

        }else{

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
    public void rollDice(ActionEvent event) throws IOException, ClassNotFoundException, InterruptedException {
        
        show(new FXMLLoader(getClass().getResource("screens/pop-up/dice/Dice.fxml")), new Stage());
        
        initDice();
         
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

            if(board.getPlayers().get(board.getTurn()).getPenalty() == 3){
                //para la carcel por 3 pares

            }


            refresh();

        }

    }

    public void refresh(){

        for(Player player : board.getPlayers().toArray()){

            int money = player.getMoney();

            switch(player.getNameToken()){
                case "BOAT":
                    moneyBoat.setText(String.valueOf(money));
                    break;
    
                case "HAT":
                    moneyHat.setText(String.valueOf(money));
                    break;
    
                case "HOLE":
                    moneyHole.setText(String.valueOf(money));
                    break;
    
                case "CAR":
                    moneyCar.setText(String.valueOf(money));
                    break;
    
                case "CAT":
                    moneyCat.setText(String.valueOf(money));
                    break;
    
                case "SHOES":
                    moneyShoes.setText(String.valueOf(money));
                    break;
    
                case "BOX":
                    moneyBox.setText(String.valueOf(money));
                    break;
    
                case "DOG":
                    moneyDog.setText(String.valueOf(money));
                    break;
    
               
    
            }
    
            
        }


    }

   
    public void initDice() throws IOException, InterruptedException {

        int diceOne = 0;
        int diceTwo = 0;

        for(int i = 0; i < TRY; i++){

            diceOne = (int) (Math.random()*5)+1;
            diceTwo = (int) (Math.random()*5)+1;

            dice1.setImage(new Image(dice(diceOne), 58, 58, true, true, true));
            dice2.setImage(new Image(dice(diceTwo), 58, 58, true, true, true));
            
        }

        numDice.setText(String.valueOf(diceOne + diceTwo));

        if((diceOne + diceTwo) % 2 == 0){
            alert("Sacaste un Numero PAR", "Puedes volver a tirar el dado");
            board.getPlayers().get(board.getTurn()).setPenalty(board.getPlayers().get(board.getTurn()).getPenalty() + 1);
            
        }else{
            board.getPlayers().get(board.getTurn()).setPenalty(0);

        }

        if(board.getPlayers().get(board.getTurn()).getPosition() + diceOne + diceTwo < 40){
            
            board.getPlayers().get(board.getTurn()).setPosition(board.getPlayers().get(board.getTurn()).getPosition() + diceOne + diceTwo);

        }else{
            board.getPlayers().get(board.getTurn()).setPosition(1 + ((diceOne + diceTwo) - (40 -  board.getPlayers().get(board.getTurn()).getPosition())));
            board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() + 200);
            
            if(board.getTurn() + 1 > board.getPlayers().size() - 1){
                board.setTurn(0);

            }else{
                board.setTurn(board.getTurn() + 1);

            }

        }

        

    }

    private String dice(int value) {

        String url = "/images/dice/";

        switch (value) {
           case 1:
                return url + "de1.jpg";
        
            case 2:
                return url + "de2.jpg";
              
            case 3:
                return url + "de3.jpg";
             
            case 4:
                return url + "de4.jpg";
              
            case 5:
                return url + "de5.jpg";
              
            case 6:
                return url + "de6.jpg";
             
            default:
                return url + "de1.jpg";
             
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
