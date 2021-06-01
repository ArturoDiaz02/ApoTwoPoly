package objects;

import java.io.Serializable;

public class FortuneCards implements Cards, Serializable {
    
	private static final long serialVersionUID = 452370941377952700L;
	private String card;
    private int idAction;

    public FortuneCards(String card, int typeAction) {
        this.card = card;
        this.idAction = typeAction;
    }

    public FortuneCards() {}

    public String getCard() {
        return this.card;
    }

    public void setCard(String card) {
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
