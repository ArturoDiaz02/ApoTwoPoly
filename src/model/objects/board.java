package objects;

import java.io.Serializable;

import data_structure.MeLinkedLists;

public class Board implements Serializable {

	private static final long serialVersionUID = 262921139849267465L;
	private MeLinkedLists<Properties> propertiesSquare;
    private MeLinkedLists<WildCards> wildCardsSquare;
    private MeLinkedLists<CommunSquare> communSquare;
    private MeLinkedLists<Player> players;
    private MeLinkedLists<CommunityServiceCards> communityServiceCards;
    private MeLinkedLists<FortuneCards> fortuneCards;
    private int turn;


    public Board(MeLinkedLists<Properties> square1, MeLinkedLists<WildCards> square2, MeLinkedLists<CommunSquare> square3, MeLinkedLists<Player> players, MeLinkedLists<CommunityServiceCards> communityServiceCards, MeLinkedLists<FortuneCards> fortuneCards) {
        this.propertiesSquare = square1;
        this.wildCardsSquare = square2;
        this.communSquare = square3;
        this.players = players;
        this.communityServiceCards = communityServiceCards;
        this.fortuneCards = fortuneCards;
        turn = 0;
    }

    public Board(){}

    public MeLinkedLists<Properties> getPropertiesSquare() {
        return this.propertiesSquare;
    }

    public void setPropertiesSquare(MeLinkedLists<Properties> propertiesSquare) {
        this.propertiesSquare = propertiesSquare;
    }

    public MeLinkedLists<WildCards> getWildCardsSquare() {
        return this.wildCardsSquare;
    }

    public void setWildCardsSquare(MeLinkedLists<WildCards> wildCardsSquare) {
        this.wildCardsSquare = wildCardsSquare;
    }

    public MeLinkedLists<CommunSquare> getCommunSquare() {
        return this.communSquare;
    }

    public void setCommunSquare(MeLinkedLists<CommunSquare> communSquare) {
        this.communSquare = communSquare;
    }

    public MeLinkedLists<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(MeLinkedLists<Player> players) {
        this.players = players;
    }

    public MeLinkedLists<CommunityServiceCards> getCommunityServiceCards() {
        return this.communityServiceCards;
    }

    public void setCommunityServiceCards(MeLinkedLists<CommunityServiceCards> communityServiceCards) {
        this.communityServiceCards = communityServiceCards;
    }

    public MeLinkedLists<FortuneCards> getFortuneCards() {
        return this.fortuneCards;
    }

    public void setFortuneCards(MeLinkedLists<FortuneCards> fortuneCards) {
        this.fortuneCards = fortuneCards;
    }

    public int getTurn() {
        return this.turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }



}
