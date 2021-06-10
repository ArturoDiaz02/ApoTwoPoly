package ui;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import objects.Board;
import objects.CommunSquare;
import objects.CommunityServiceCards;
import objects.FortuneCards;
import objects.Properties;
import objects.PublicServices;
import objects.Token;
import objects.Train;
import threads.CommunThreads;
import threads.HousesAndHotelThreads;
import threads.ImageOrderingThreads;
import threads.PanesOrderingThreads;
import threads.PlayerProperties;
import threads.PropertiesThreads;
import threads.PublicServicesThreads;
import threads.TrainThreads;
import threads.WildCardsThreads;

public class ApoTwoPolyGUI extends AttributesGUI{

    //**************************************************************************
    // Object GUI

    public ApoTwoPolyGUI(Board board) {
        localStage = new Stage();
        this.board = board;
        
    }
    
    public ApoTwoPolyGUI() {
        localStage = new Stage();
        this.board = new Board();
    }

    public void setBoard(Board board) throws IOException{ this.board = board; refresh();}
    public void setLocalStage(Stage stage){ this.localStage = stage;}

    //**************************************************************************
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
    
            if(checkBoat.isSelected()){
                paneBoat.setOpacity(1);
                tokenBoat.setVisible(true);
                board.getPlayers().add(new Token(TOTALMONEY, tokenBoat, "BOAT", board.getPlayers().size() + 1));
                
            }

            if(checkBox.isSelected()){
                paneBox.setOpacity(1);
                tokenBox.setVisible(true);
                board.getPlayers().add(new Token(TOTALMONEY, tokenBox, "BOX",  board.getPlayers().size() + 1));
                
            }
    
            if(checkCar.isSelected()){
                paneCar.setOpacity(1);
                tokenCar.setVisible(true);
                board.getPlayers().add(new Token(TOTALMONEY, tokenCar, "CAR",  board.getPlayers().size() + 1));
                
            }
    
            if(checkCat.isSelected()){
                paneCat.setOpacity(1);
                tokenCat.setVisible(true);
                board.getPlayers().add(new Token(TOTALMONEY, tokenCat, "CAT",  board.getPlayers().size() + 1));
                
            }
    
            if(checkDog.isSelected()){
                paneDog.setOpacity(1);
                tokenDog.setVisible(true);
                board.getPlayers().add(new Token(TOTALMONEY, tokenDog, "DOG",  board.getPlayers().size() + 1));
                
            }
    
            if(checkHat.isSelected()){
                paneHat.setOpacity(1);
                tokenHat.setVisible(true);
                board.getPlayers().add(new Token(TOTALMONEY, tokenHat, "HAT",  board.getPlayers().size() + 1));
                
            }
    
            if(checkHole.isSelected()){
                paneHole.setOpacity(1);
                tokenHole.setVisible(true);
                board.getPlayers().add(new Token(TOTALMONEY, tokenHole, "HOLE",  board.getPlayers().size() + 1));
                
            }
    
            if(checkShoes.isSelected()){
                paneShoes.setOpacity(1);
                tokenShoes.setVisible(true);
                board.getPlayers().add(new Token(TOTALMONEY, tokenShoes, "SHOES",  board.getPlayers().size() + 1));
                
            }

            threadPanesOrdering = new PanesOrderingThreads(paneBoat, paneBox, paneCar, paneCat, paneDog, paneHat, paneHole, paneShoes, this);
            threadPanesOrdering.start();

            alert("INFORMACION", "*. Con las teclas W,A,S,D el jugador en turno puede mover su token sobre el tablero.\n*. Tecla ENTER para ejecutar la accion de una casilla.\n*. Tecla P para pasar de turno");


        }
        
    }

    @FXML
    public void goAllProperties(ActionEvent event) throws IOException, ClassNotFoundException {

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());

        threadImageOrdering = new ImageOrderingThreads(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, this, board);
        threadImageOrdering.start();
        
       
    }

    @FXML
    public void goDeal(ActionEvent event) throws IOException, ClassNotFoundException {
        
        show(new FXMLLoader(getClass().getResource("screens/pop-up/deal/Deal.fxml")), new Stage());
       
    }

    @FXML
    public void rollDice(ActionEvent event) throws IOException, ClassNotFoundException, InterruptedException {

        if(validationMove()){
        
            show(new FXMLLoader(getClass().getResource("screens/pop-up/dice/Dice.fxml")), new Stage());
            initDice();

        }else{

            show(new FXMLLoader(getClass().getResource("screens/pop-up/payJail/Jail.fxml")), new Stage());
            labelPayJail.setText("Espera " + (board.getPlayers().get(board.getTurn()).getPenalty() + 1) + " turnos o paga la fianza de $500");
            buttonRollDice.setDisable(true);

        }
         
    }

    @FXML
    public void playerPropertiesBoat(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
        threadPlayerProperties = new PlayerProperties(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, board, "BOAT");
        threadPlayerProperties.start();

    }

    @FXML
    public void playerPropertiesBox(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
        threadPlayerProperties = new PlayerProperties(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, board, "BOX");
        threadPlayerProperties.start();

    }

    @FXML
    public void playerPropertiesCar(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
        threadPlayerProperties = new PlayerProperties(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, board, "CAR");
        threadPlayerProperties.start();

    }

    @FXML
    public void playerPropertiesCat(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
        threadPlayerProperties = new PlayerProperties(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, board, "CAT");
        threadPlayerProperties.start();

    }

    @FXML
    public void playerPropertiesDog(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
        threadPlayerProperties = new PlayerProperties(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, board, "DOG");
        threadPlayerProperties.start();

    }

    @FXML
    public void playerPropertiesHat(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
        threadPlayerProperties = new PlayerProperties(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, board, "HAT");
        threadPlayerProperties.start();

    }

    @FXML
    public void playerPropertiesHole(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
        threadPlayerProperties = new PlayerProperties(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, board, "HOLE");
        threadPlayerProperties.start();

    }

    @FXML
    public void playerPropertiesShoes(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
        threadPlayerProperties = new PlayerProperties(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, board, "SHOES");
        threadPlayerProperties.start();

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

    //**************************************************************************
    // leave Screens

    @FXML
    public void mainLeave(ActionEvent event) {

        localStage.close();

    }


    //**************************************************************************
    // Move

    @FXML
    public void moveToken(KeyEvent event) throws ClassNotFoundException, IOException {

        switch (board.getPlayers().get(board.getTurn()).getNameToken()) {
            case "BOAT":
                tokenBoat = board.getPlayers().bSearchToken(board.getTurn()).moveUp(event.getCode());
                break;
        
            case "BOX":
                tokenBox = board.getPlayers().bSearchToken(board.getTurn()).moveUp(event.getCode());
                break;

            case "CAR":
                tokenCar = board.getPlayers().bSearchToken(board.getTurn()).moveUp(event.getCode());
                break;

            case "CAT":
                tokenCat = board.getPlayers().bSearchToken(board.getTurn()).moveUp(event.getCode());
                break;

            case "DOG":
                tokenDog = board.getPlayers().bSearchToken(board.getTurn()).moveUp(event.getCode());
                break;

            case "HAT":
                tokenHat = board.getPlayers().bSearchToken(board.getTurn()).moveUp(event.getCode());
                break;

            case "HOLE":
                tokenHole = board.getPlayers().bSearchToken(board.getTurn()).moveUp(event.getCode());
                break;

            case "SHOES":
                tokenShoes = board.getPlayers().bSearchToken(board.getTurn()).moveUp(event.getCode());
                break;
        }

        if(event.getCode() == KeyCode.ENTER){

            threadCommun = new CommunThreads(board, this);
            threadProperties = new PropertiesThreads(board, this, true);
            threadWildCards = new WildCardsThreads(board, this);
            threadPublicServices = new PublicServicesThreads(board, this, true);
            threadTrain = new TrainThreads(board, this, true);

            threadPublicServices.start();
            threadTrain.start();
            threadCommun.start();
            threadProperties.start();
            threadWildCards.start();

        }

        if(event.getCode() == KeyCode.P){

            interaction();

        }


    }

    

    //**************************************************************************
    // Dice

    private void initDice() throws IOException, InterruptedException {

        int diceOne = 0;
        int diceTwo = 0;
    
        for(int i = 0; i < TRY; i++){
    
            diceOne = (int) (Math.random()*6)+1;
            diceTwo = (int) (Math.random()*6)+1;

            dice1.setImage(new Image(dice(diceOne), 58, 58, true, true, true));
            dice2.setImage(new Image(dice(diceTwo), 58, 58, true, true, true));
                
        }
    
        numDice.setText(String.valueOf(diceOne + diceTwo));
        buttonRollDice.setDisable(true);
    
        if(registerLabel.getText().equals("")){
            registerLabel.setText(board.getPlayers().get(board.getTurn()).getNameToken() + " saco " + (diceOne + diceTwo) + " en los dados.\n");
    
        }else{
            registerLabel.setText(registerLabel.getText() + board.getPlayers().get(board.getTurn()).getNameToken() + " saco " + (diceOne + diceTwo) + " en los dados.\n");
        }
    
        if(diceOne == diceTwo){  

            board.getPlayers().get(board.getTurn()).setPenalty(board.getPlayers().get(board.getTurn()).getPenalty() + 1);

            if(board.getPlayers().get(board.getTurn()).getPenalty() == 3){
                actionCommunSquare(board.getCommunSquare().get(4));
    
            }else{
                alert("Sacaste un Numero PAR", "Puedes volver a tirar el dado");
                board.getPlayers().get(board.getTurn()).setPar(true);

            }

            registerLabel.setText(registerLabel.getText() + board.getPlayers().get(board.getTurn()).getNameToken() + " saco PAR.\n");
            buttonRollDice.setDisable(false);
    
        }else{
            board.getPlayers().get(board.getTurn()).setPenalty(0);
            board.getPlayers().get(board.getTurn()).setPar(false);
    
        }

        if(board.getPlayers().get(board.getTurn()).getPosition() + diceOne + diceTwo < 40){
                
            board.getPlayers().get(board.getTurn()).setPosition(board.getPlayers().get(board.getTurn()).getPosition() + diceOne + diceTwo);
    
        }else{
    
            board.getPlayers().get(board.getTurn()).setPosition(((diceOne + diceTwo) - (40 -  board.getPlayers().get(board.getTurn()).getPosition())));
            board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() + 200);
                
    
        }

        
    }

    private boolean validationMove(){

        boolean vali = true;
        
        if(board.getCommunSquare().get(2).getJail().getHead() != null){

            for(Token token : board.getCommunSquare().get(2).getJail().toArray()){

                if(board.getPlayers().get(board.getTurn()).getNameToken().equals(token.getNameToken())){
    
                    vali = false;
                    board.getPlayers().get(board.getTurn()).setPenalty(board.getPlayers().get(board.getTurn()).getPenalty() - 1);

                    if(board.getPlayers().get(board.getTurn()).getPenalty() == 0){
                        board.getPlayers().get(board.getTurn()).setJail(false);
                        board.getCommunSquare().get(2).getJail().remove(board.getCommunSquare().get(2).getJail().indexOf(token));
                        vali = true;

                    }

                    break;
    
                }
            }
        }

        return vali;

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

    //**************************************************************************
    // Threads

    public void actionFortuneCard(FortuneCards card) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/properties/viewWild.fxml")), new Stage());
        imageWild.setImage(new Image(card.getCard()));

    }

    public void actionCommunityCard(CommunityServiceCards card) throws IOException{
        show(new FXMLLoader(getClass().getResource("screens/pop-up/properties/viewWild.fxml")), new Stage());
        imageWild.setImage(new Image(card.getCard()));

    }

    public void actionCommunSquare(CommunSquare communSquare) throws IOException{

        if(communSquare.getAction() == 2){
            alert("Mala Suerte", "Dirigete a la carcel para cumplir tu condena");
            board.getPlayers().get(board.getTurn()).setPosition(10);
            board.getPlayers().get(board.getTurn()).setPenalty(3);
            board.getPlayers().get(board.getTurn()).setJail(true);
            board.getCommunSquare().get(2).getJail().add(board.getPlayers().get(board.getTurn()));
            
        }else if(communSquare.getAction() == 5){
            alert("Mala Suerte", "Pagas un impuesto de " + communSquare.getTax());

            if(board.getPlayers().get(board.getTurn()).getMoney() >= communSquare.getTax()){
                board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() - communSquare.getTax());
                refresh();

            }else{
                //no tiene para pagar

            }

        }
        

    }


    public void actionProperties(Properties propertie) throws IOException{
        
        if(propertie.getOwner() != null && propertie.getOwner() != board.getPlayers().get(board.getTurn())){

            int amout = propertie.getMortgage();

            if(propertie.getHouses() != 0 && !(propertie.getHotel())){
                amout = propertie.getRentalHousesAndHotel()[propertie.getHouses() - 1];

            }else if(propertie.getHotel()){
                amout = propertie.getRentalHousesAndHotel()[4];

            }

        
            if (board.getPlayers().get(board.getTurn()).getMoney() >= amout) {
                board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() - amout);
                propertie.getOwner().setMoney(propertie.getOwner().getMoney() + amout);
                alert("Mala Suerte", "La propiedad tiene dueño y le pagaste $" +  amout + " de arriendo a " + propertie.getOwner().getNameToken());
                refresh();

            }else{
                //si no tiene dinero sificiente para pagar

            }

        }else if(propertie.getOwner() == board.getPlayers().get(board.getTurn())){ //compra casas y hoteles
            auxPropertie = propertie;
            show(new FXMLLoader(getClass().getResource("screens/pop-up/properties/sellHouseOrHotel.fxml")), new Stage());
            imageProperti.setImage(new Image(propertie.getProperty()));

        }else{
            show(new FXMLLoader(getClass().getResource("screens/pop-up/properties/viewProperti.fxml")), new Stage());
            imageProperti.setImage(new Image(propertie.getProperty()));
            costPropertie.setText("$" + propertie.getCostProperty());

        }

    }

    public void actionProperties(Train propertie) throws IOException{
        
        if(propertie.getOwner() != null && propertie.getOwner() != board.getPlayers().get(board.getTurn())){

            int valor = 25;

            if(board.getPlayers().get(board.getTurn()).getTrains().size() == 2){
                valor = 50;

            }else if(board.getPlayers().get(board.getTurn()).getTrains().size() == 3){
                valor = 100;

            }else if(board.getPlayers().get(board.getTurn()).getTrains().size() == 4){
                valor = 200;

            }

            if (board.getPlayers().get(board.getTurn()).getMoney() >= valor) {

                board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() - valor);
                propertie.getOwner().setMoney(propertie.getOwner().getMoney() + valor);
                alert("Mala Suerte", "La propiedad tiene dueño, se te cobrara segun la cantidad de estaciones que este posea.\n" + "*. Cantidad de estaciones: " +  board.getPlayers().get(board.getTurn()).getTrains().size() + "\n El valor a pagar a " + propertie.getOwner().getNameToken() + " es $" + valor);
                refresh();

            }else{
                //si no tiene dinero sificiente para pagar

            }

        }else{
            show(new FXMLLoader(getClass().getResource("screens/pop-up/properties/viewProperti.fxml")), new Stage());
            imageProperti.setImage(new Image(propertie.getProperty()));
            costPropertie.setText("$" + propertie.getCostProperty());

        }


    }

    public void actionProperties(PublicServices propertie) throws IOException{
        
        if(propertie.getOwner() != null && propertie.getOwner() != board.getPlayers().get(board.getTurn())){
        
            int multiplier = 4;
          
            if(board.getPlayers().get(board.getTurn()).getPublicServices().size() == 2){
                multiplier = 10;
             
            }

            int diceOne = (int) (Math.random()*6)+1;
            int diceTwo = (int) (Math.random()*6)+1;

            int valor = (diceOne + diceTwo) * multiplier;


            if (board.getPlayers().get(board.getTurn()).getMoney() >= valor) {
                board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() - valor);
                propertie.getOwner().setMoney(propertie.getOwner().getMoney() + valor);
                alert("Mala Suerte", "La propiedad tiene dueño, se te cobrara la suma de los valores que arrojen los dados y se multiplicara segun los servicion que posea" + "\n*. Suma de los dados: " + (diceOne + diceTwo) + "\n*. Multiplicidad: " + multiplier + "\nValor total a pagar a " + propertie.getOwner().getNameToken() + " es $" + valor);
                refresh();

            }else{
                //si no tiene dinero sificiente para pagar

            }

        }else{
            show(new FXMLLoader(getClass().getResource("screens/pop-up/properties/viewProperti.fxml")), new Stage());
            imageProperti.setImage(new Image(propertie.getProperty()));
            costPropertie.setText("$" + propertie.getCostProperty());

        }
       
    }

    //**************************************************************************************************************************
    // Methods

    private void alert(String title, String mss){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(mss);
        alert.showAndWait();
        
    }

    private void interaction() throws IOException{

        refresh();

        if(!(board.getPlayers().get(board.getTurn()).getPar()) && !(board.getPlayers().get(board.getTurn()).getJail())){

            tokenOffSide();

            if(board.getTurn() + 1 == board.getPlayers().size()){
                board.setTurn(0);
        
            }else{
                board.setTurn(board.getTurn() + 1);
        
            }

            tokenInGame();
            buttonRollDice.setDisable(false);

        }else{
            board.getPlayers().get(board.getTurn()).setJail(false);

        }

        
     
        
       
    }

    private void refresh(){

        for(Token player : board.getPlayers().toArray()){

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


    @FXML
    public void buyProperti(ActionEvent event) {
        threadProperties =  new PropertiesThreads(board, this, false);
        threadTrain = new TrainThreads(board, this, false);
        threadPublicServices = new PublicServicesThreads(board, this, false);

        threadPublicServices.start();
        threadTrain.start();
        threadProperties.start();

    }

    
    @FXML
    public void payJail(ActionEvent event) {

        if(board.getPlayers().get(board.getTurn()).getMoney() >= 500){
            board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() - 500);
            board.getPlayers().get(board.getTurn()).setPenalty(0);
            alert("Vaya", "Ya estas libre pero tienes que esperar al siguiente turno para jugar");

        }else{
            alert("Estas Pobre", "No tienes el dinero suficiente para pagar la fianza");

        }
        

    }

    private void tokenInGame(){

        String url = "/images/graphic/rectangleGameTurn.jpg";

        switch(board.getPlayers().get(board.getTurn()).getNameToken()){
            case "BOAT":
                imageViewBoat.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "HAT":
                imageViewHat.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "HOLE":
                imageViewHole.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "CAR":
                imageViewCar.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "CAT":
                imageViewCat.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "SHOES":
                imageViewShoes.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "BOX":
                imageViewBox.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "DOG":
                imageViewDog.setImage(new Image(url, 548, 109, true, true, true));
                break;

        }

    }

    private void tokenOffSide(){

        String url = "/images/graphic/rectangleGame.jpg";

        switch(board.getPlayers().get(board.getTurn()).getNameToken()){
            case "BOAT":
                imageViewBoat.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "HAT":
                imageViewHat.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "HOLE":
                imageViewHole.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "CAR":
                imageViewCar.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "CAT":
                imageViewCat.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "SHOES":
                imageViewShoes.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "BOX":
                imageViewBox.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "DOG":
                imageViewDog.setImage(new Image(url, 548, 109, true, true, true));
                break;

        }

    }

    public void playerOrdering(ArrayList<Pane> panes){

        for(int i = 0; i < panes.size(); i++){

            GridPane.setConstraints(panes.get(i), 0, i);

        }

        tokenInGame();

    }

    public void propertiesOrdering(ArrayList<ImageView> imageViews) throws IOException{

        int aux = 0;

        for(int i = 0; i < 4; i++){

            for(int l = 0; l < 7; l++){

                GridPane.setConstraints(imageViews.get(aux), l, i);

                aux++;
    
            }

        }

        

    }

    @FXML
    public void buyHouse(ActionEvent event) {

        localStage.close();

        if(board.getPlayers().get(board.getTurn()).getMoney() >= auxPropertie.getCostHousesAndHotel() && auxPropertie.getHouses() < 4){

            board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() - auxPropertie.getCostHousesAndHotel());
            refresh();
            HousesAndHotelThreads threads = new HousesAndHotelThreads(house44, house43, house42, house41, hotel12, house48, house47, house46, house45, hotel13, house52, house51, house50, house49, hotel14, house56, house55, house54, house53, hotel15, house60, house59, house58, house57, hotel16, house64, house63, house62, house61, hotel17, house40, house39, house38, house37, hotel11, house36, house35, house34, house33, hotel10, house32, house31, house30, house29, hotel9, hotel8, house28, house27, house26, house25, hotel7, house24, house23, house22, house21, hotel6, house17, house18, house19, house20, hotel5, house13, house14, house15, house16, hotel4, house9, house10, house11, house12, hotel3, house5, house6, house7, house8, hotel2, house1, house2, house3, house4, hotel1, house81, house82, house83, house84, hotel22, house77, house78, house79, house80, hotel21, house73, house74, house75, house76, hotel20, house69, house70, house71, house72, hotel19, house65, house66, house67, house68, hotel18, house85, house86, house87, house88, board, auxPropertie, true);
            threads.start();

        }else{
            alert("Upsss", "Parece que no tienes dinero para hacer la compra o ya tienes las 4 casas");
            
        }

        

    }

    @FXML
    public void buyHotel(ActionEvent event) {

        localStage.close();

        int houses = 0;

        for(Properties pr : board.getPlayers().get(board.getTurn()).getProperties().toArray()){

            if(pr.getFamily() == auxPropertie.getFamily()){
                houses += pr.getHouses();

            }

        }

        if(board.getPlayers().get(board.getTurn()).getMoney() >= auxPropertie.getCostHousesAndHotel() && houses == auxPropertie.getAmountFamily() * 4){

            board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() - auxPropertie.getCostHousesAndHotel());
            refresh();
            HousesAndHotelThreads threads = new HousesAndHotelThreads(house44, house43, house42, house41, hotel12, house48, house47, house46, house45, hotel13, house52, house51, house50, house49, hotel14, house56, house55, house54, house53, hotel15, house60, house59, house58, house57, hotel16, house64, house63, house62, house61, hotel17, house40, house39, house38, house37, hotel11, house36, house35, house34, house33, hotel10, house32, house31, house30, house29, hotel9, hotel8, house28, house27, house26, house25, hotel7, house24, house23, house22, house21, hotel6, house17, house18, house19, house20, hotel5, house13, house14, house15, house16, hotel4, house9, house10, house11, house12, hotel3, house5, house6, house7, house8, hotel2, house1, house2, house3, house4, hotel1, house81, house82, house83, house84, hotel22, house77, house78, house79, house80, hotel21, house73, house74, house75, house76, hotel20, house69, house70, house71, house72, hotel19, house65, house66, house67, house68, hotel18, house85, house86, house87, house88, board, auxPropertie, false);
            threads.start();

        }else{
            alert("Upsss", "Parece que no tienes dinero para hacer la compra o no tienes las 4 casas");
            
        }

        
    }
   

    
	
	
}
