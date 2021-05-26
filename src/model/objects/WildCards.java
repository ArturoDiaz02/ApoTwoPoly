package model.objects;

public class WildCards extends Square {

    private boolean typeWildCards;

    public WildCards(int numSquare, int typeSquare, boolean typeWildCards) {
        super(numSquare, typeSquare);
        this.typeWildCards = typeWildCards;
    }

    public boolean isTypeWildCards() {
        return this.typeWildCards;
    }

    public void setTypeWildCards(boolean typeWildCards) {
        this.typeWildCards = typeWildCards;
    }

    public void ramdon(){

    }
    
}
