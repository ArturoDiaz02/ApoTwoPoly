package model.objects;

public class CommunSquare extends Square{
    
    private int action;
    
    //1 = go, 2 = go carcel, 3 = carcel, 4 = free, 5 = impuestos
    public CommunSquare(int numSquare, int typeSquare, int action) {
        super(numSquare, typeSquare);
        this.action = action;
    }

    public int getAction() {
        return this.action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public void selectAction(){

    }

}
