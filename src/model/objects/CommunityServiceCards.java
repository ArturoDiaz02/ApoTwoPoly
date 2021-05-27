package objects;

import java.io.Serializable;

public class CommunityServiceCards implements Cards, Serializable{
    
	private static final long serialVersionUID = 7550310221349172151L;
	private String card;
    private int idAction;

    public CommunityServiceCards(String card, int typeAction) {
        this.card = card;
        this.idAction = typeAction;
    }

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
