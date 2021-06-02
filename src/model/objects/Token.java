package objects;

import data_structure.MeLinkedLists;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Token extends Player{
    
    private ImageView token;
    private static final int PIXEL = 8;


    public Token(MeLinkedLists<Square> properties, MeLinkedLists<CommunityServiceCards> especialCommunityCards, MeLinkedLists<FortuneCards> especialFortuneCards, int money, ImageView token, String nameToken) {
        super(properties, especialCommunityCards, especialFortuneCards, money, nameToken);
        this.token = token;
        
    }

    public Token(ImageView token){
        super();
        this.token = token;
    }

    public ImageView getToken() {
        return this.token;
    }

    public void setToken(ImageView token) {
        this.token = token;
    }


    public ImageView moveUp(KeyCode event){

        double x = token.getLayoutX();
        double y = token.getLayoutY();

        if(event == KeyCode.A){
            x = x - PIXEL;
        }

        if(event == KeyCode.D){
            x = x + PIXEL;
        }

        if(event == KeyCode.W){
            y = y - PIXEL;
        }

        if(event == KeyCode.S){
            y = y + PIXEL;
        }

        token.setLayoutX(x);
        token.setLayoutY(y);

        return token;
        

    }



    
}
