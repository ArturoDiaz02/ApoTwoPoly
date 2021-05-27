package objects;

import java.io.Serializable;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import data_structure.MeLinkedLists;

public class Player implements Serializable{
  
	private static final long serialVersionUID = 5780182730822343543L;
	private MeLinkedLists<Square> properties;
    private MeLinkedLists<CommunityServiceCards> especialCommunityCards;
    private MeLinkedLists<FortuneCards> especialFortuneCards;
    private int money;
    private int position;
    private String nameToken;
    private ImageView token;

    public Player(MeLinkedLists<Square> properties, MeLinkedLists<CommunityServiceCards> especialCommunityCards, MeLinkedLists<FortuneCards> especialFortuneCards, int money, ImageView token, String nameToken) {
        this.properties = properties;
        this.especialCommunityCards = especialCommunityCards;
        this.especialFortuneCards = especialFortuneCards;
        this.money = money;
        this.position = 0;
        this.token = token;
        this.nameToken = nameToken;
    }
    
    public Player(ImageView token) {
    	this.token = token;
    	
    }

   

    public MeLinkedLists<Square> getProperties() {
        return this.properties;
    }

    public void setProperties(MeLinkedLists<Square> properties) {
        this.properties = properties;
    }

    public MeLinkedLists<CommunityServiceCards> getEspecialCommunityCards() {
        return this.especialCommunityCards;
    }

    public void setEspecialCommunityCards(MeLinkedLists<CommunityServiceCards> especialCommunityCards) {
        this.especialCommunityCards = especialCommunityCards;
    }

    public MeLinkedLists<FortuneCards> getEspecialFortuneCards() {
        return this.especialFortuneCards;
    }

    public void setEspecialFortuneCards(MeLinkedLists<FortuneCards> especialFortuneCards) {
        this.especialFortuneCards = especialFortuneCards;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getNameToken() {
        return this.nameToken;
    }

    public void setNameToken(String nameToken) {
        this.nameToken = nameToken;
    }

    public ImageView getToken() {
        return this.token;
    }

    public void setToken(ImageView token) {
        this.token = token;
    }
    
    public void createPlayer() {
    	
    	
    	
    }

    public ImageView moveUp(KeyCode event){

        double x = token.getLayoutX();
        double y = token.getLayoutY();

        if(event == KeyCode.A){
            x = x - 8;
        }

        if(event == KeyCode.D){
            x = x + 8;
        }

        if(event == KeyCode.W){
            y = y - 8;
        }

        if(event == KeyCode.S){
            y = y + 8;
        }

        token.setLayoutX(x);
        token.setLayoutY(y);

        return token;
        

    }

    

}