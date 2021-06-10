package objects;

public class PublicServices extends Properties{

    public PublicServices(String property, int costProperty, int numSquare, int typeSquare, int mortgage, String imageView) {
        super(property, costProperty, numSquare, typeSquare, mortgage, imageView);
    }

    public PublicServices() {}

    public void action(){

    }

    @Override
    public PublicServices propeties(Board board, int index){
        return board.getPublicServicesSquare().get(index);
    }
    
}
