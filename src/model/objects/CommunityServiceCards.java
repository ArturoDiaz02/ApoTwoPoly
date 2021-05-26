package model.objects;

import java.io.Serializable;

import javafx.scene.image.ImageView;

public class CommunityServiceCards implements Cards, Serializable{
    
    private ImageView card;
    private int idAction;

    public CommunityServiceCards(ImageView card, int typeAction) {
        this.card = card;
        this.idAction = typeAction;
    }

    public ImageView getCard() {
        return this.card;
    }

    public void setCard(ImageView card) {
        this.card = card;
    }

    public int getIdAction() {
        return this.idAction;
    }

    public void setIdAction(int typeAction) {
        this.idAction = typeAction;
    }

    public void action(){
        

    }

}
