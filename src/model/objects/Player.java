package model.objects;

import java.io.Serializable;

import model.data_structure.MeLinkedLists;

public class Player implements Serializable{
    
    private MeLinkedLists<Square> properties;
    private MeLinkedLists<CommunityServiceCards> especialCommunityCards;
    private MeLinkedLists<FortuneCards> especialFortuneCards;
    private int money;
    private int position;

    public Player(MeLinkedLists<Square> properties, MeLinkedLists<CommunityServiceCards> especialCommunityCards, MeLinkedLists<FortuneCards> especialFortuneCards, int money) {
        this.properties = properties;
        this.especialCommunityCards = especialCommunityCards;
        this.especialFortuneCards = especialFortuneCards;
        this.money = money;
        this.position = 0;
    }

    public MeLinkedLists<Square> getProperties() {
        return this.properties;
    }

    public void setProperties(MeLinkedLists<Square> properties) {
        this.properties = properties;
    }

    public MeLinkedLists<CommunityServiceCards> getEspecialCommunityCards() {
        return this.especialCommunityCards;
    }

    public void setEspecialCommunityCards(MeLinkedLists<CommunityServiceCards> especialCommunityCards) {
        this.especialCommunityCards = especialCommunityCards;
    }

    public MeLinkedLists<FortuneCards> getEspecialFortuneCards() {
        return this.especialFortuneCards;
    }

    public void setEspecialFortuneCards(MeLinkedLists<FortuneCards> especialFortuneCards) {
        this.especialFortuneCards = especialFortuneCards;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
   

}
