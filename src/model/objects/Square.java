package model.objects;

import java.io.Serializable;

import model.data_structure.MeLinkedLists;

public class Square implements Serializable{

    private int numSquare;
    private int typeSquare;
    private MeLinkedLists<Player> players;

    public Square(int numSquare, int typeSquare) {
        this.numSquare = numSquare;
        this.typeSquare = typeSquare;
        this.players = new MeLinkedLists<>();
    }

    public int getNumSquare() {
        return this.numSquare;
    }

    public void setNumSquare(int numSquare) {
        this.numSquare = numSquare;
    }

    public int getTypeSquare() {
        return this.typeSquare;
    }

    public void setTypeSquare(int typeSquare) {
        this.typeSquare = typeSquare;
    }

    public MeLinkedLists<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(MeLinkedLists<Player> players) {
        this.players = players;
    }
   
    
}
