package model.objects;

import java.io.Serializable;

import model.data_structure.MeLinkedLists;

public class Board implements Serializable {

    private MeLinkedLists<Square> square;
    private MeLinkedLists<Player> players;
    private MeLinkedLists<CommunityServiceCards> communityServiceCards;
    private MeLinkedLists<FortuneCards> fortuneCards;
    private int turn;


    public Board(MeLinkedLists<Square> square, MeLinkedLists<Player> players, MeLinkedLists<CommunityServiceCards> communityServiceCards, MeLinkedLists<FortuneCards> fortuneCards) {
        this.square = square;
        this.players = players;
        this.communityServiceCards = communityServiceCards;
        this.fortuneCards = fortuneCards;
        turn = 0;
    }

    public MeLinkedLists<Square> getSquare() {
        return this.square;
    }

    public void setSquare(MeLinkedLists<Square> square) {
        this.square = square;
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
