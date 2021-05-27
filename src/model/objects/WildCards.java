package objects;

public class WildCards extends Square {

	private static final long serialVersionUID = 192875853834156303L;
	private boolean typeWildCards; // true es community y false fortune

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
