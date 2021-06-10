package objects;

public class Train extends Properties{

    public Train(String property, int costProperty, int rentalProperty, int numSquare, int typeSquare, int mortgage, String imageView) {
        super(property, costProperty, rentalProperty, numSquare, typeSquare, mortgage, imageView);
    }

    public Train(){}

    public void action(){
        
    }

    @Override
    public Train propeties(Board board, int index){
        return board.getTrainSquare().get(index);
    }
    
}
