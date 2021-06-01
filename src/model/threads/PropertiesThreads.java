package threads;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import objects.Board;
import objects.Properties;
import javafx.scene.image.Image;
import java.io.File;

public class PropertiesThreads extends Thread{

    @FXML private ImageView imageProperti;

    private Board board;
    private Stage localStage;
    private int index = 0;
    private int turn;
    private int position;

    public PropertiesThreads(Board board) {
        this.board = board;

    }

    @Override
    public void run(){

        int vali = 0;
        turn = board.getTurn();
        position = board.getPlayers().get(turn).getPosition();


        for(Properties square : board.getPropertiesSquare().toArray()){
            if(square.getNumSquare() == position){
                squareProperties();
                vali = 1;
                break;
            }

            index++;
        }

        if(vali == 1){
            serializable();

        }
        

    }

    public void squareProperties(){

        if(board.getPropertiesSquare().get(index).getOwner() != null){
            if (board.getPlayers().get(turn).getMoney() >= board.getPropertiesSquare().get(index).getMortgage()) {
                board.getPlayers().get(turn).setMoney(board.getPlayers().get(turn).getMoney() - board.getPropertiesSquare().get(index).getMortgage());
                board.getPropertiesSquare().get(index).getOwner().setMoney(board.getPropertiesSquare().get(index).getOwner().getMoney() + board.getPropertiesSquare().get(index).getMortgage());
                alert("Mala Suerte", "La propiedad tiene dueño y le pagaste $" +  board.getPropertiesSquare().get(index).getMortgage() + " de arriendo a " + board.getPropertiesSquare().get(index).getOwner().getNameToken());
               
            }else if(board.getPlayers().get(turn).getMoney() < board.getPropertiesSquare().get(index).getMortgage()){
                //si no tiene dinero sificiente para pagar

            }

        }else if(board.getPropertiesSquare().get(index).getOwner() == board.getPlayers().get(turn)){
            //hacer casa y hoteles

        }else{
            show(new FXMLLoader(getClass().getResource("screens/pop-up/properties/viewProperti.fxml")), index);

        }
        
    }

    private void alert(String title, String mss){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(mss);
        alert.showAndWait();
    }

    private void show(FXMLLoader fxmlLoader, int index){

        localStage = new Stage();

        try {

            fxmlLoader.setController(this);
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            localStage.setScene(scene);
            localStage.setTitle("ApoTwoPoly");
            localStage.show();

        } catch (Exception e) {}
    
        imageProperti.setImage(new Image(new File(board.getPropertiesSquare().get(index).getProperty()).toURI().toString()));
        
    }

    public void serializable(){
       
        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data\\Data.txt"));
            oos.writeObject(board);
            oos.close();

        } catch (Exception e) {}
    }

    @FXML
    void buyProperti(ActionEvent event) {
        
        if (board.getPlayers().get(turn).getMoney() >= board.getPropertiesSquare().get(index).getCostProperty()) {
            board.getPlayers().get(turn).setMoney(board.getPlayers().get(turn).getMoney() - board.getPropertiesSquare().get(index).getCostProperty());
            board.getPropertiesSquare().get(index).setOwner(board.getPlayers().get(turn));
               
        }else{
            alert("Mala Suerte", "No cuentas con el dinero necesario para la compra");


        }

        

    }
    
}
