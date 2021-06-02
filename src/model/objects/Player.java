package objects;

import java.io.Serializable;
import data_structure.MeLinkedLists;

public abstract class Player implements Serializable{
  
	private static final long serialVersionUID = 5780182730822343543L;
	private MeLinkedLists<Square> properties;
    private MeLinkedLists<CommunityServiceCards> especialCommunityCards;
    private MeLinkedLists<FortuneCards> especialFortuneCards;
    private int money;
    private int position;
    private String nameToken;
    private int penalty;
    private boolean par;

    protected Player(MeLinkedLists<Square> properties, MeLinkedLists<CommunityServiceCards> especialCommunityCards, MeLinkedLists<FortuneCards> especialFortuneCards, int money,  String nameToken) {
        this.properties = properties;
        this.especialCommunityCards = especialCommunityCards;
        this.especialFortuneCards = especialFortuneCards;
        this.money = money;
        this.position = 0;
        this.nameToken = nameToken;
        this.penalty = 0;
        this.par = false;
    }
    
    protected Player() {}

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

    public String getNameToken() {
        return this.nameToken;
    }

    public void setNameToken(String nameToken) {
        this.nameToken = nameToken;
    }

    public int getPenalty() {
        return this.penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public boolean isPar() {
        return this.par;
    }

    public boolean getPar() {
        return this.par;
    }

    public void setPar(boolean par) {
        this.par = par;
    }
   

    

}
