package objects;

import interface_class.Cards;

public class WildCards extends Square implements Cards {

	private static final long serialVersionUID = 192875853834156303L;
	private boolean typeWildCards; // true es community y false fortune

    public WildCards(int numSquare, int typeSquare, boolean typeWildCards) {
        super(numSquare, typeSquare);
        this.typeWildCards = typeWildCards;
    }

    public WildCards() {
        super();
    }

    public boolean isTypeWildCards() {
        return this.typeWildCards;
    }

    public void setTypeWildCards(boolean typeWildCards) {
        this.typeWildCards = typeWildCards;
    }

    public CommunityServiceCards communityService(Board board, int index){
        return board.getCommunityServiceCards().get(index);
    }

    public FortuneCards fortuneCard(Board board, int index){
        return board.getFortuneCards().get(index);
        
    }

    @Override
    public Board action(Board board) {
        return null;
    }

    @Override
    public Board setMoney(Board board, int aux) {
        return null;
    }
    
}
