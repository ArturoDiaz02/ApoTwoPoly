package objects;

public class Properties extends Square{
    
	private static final long serialVersionUID = -1150550527535536653L;
	private String property;
    private String imageView;
    private Player owner;
    private int costProperty;
    private int rentalProperty;
    private int houses;
    private boolean hotel;
    private int costHousesAndHotel;
    private int[] rentalHousesAndHotel;
    private int mortgage;
    private int family;
    private int amountFamily;
    private int hierarchy;


    public Properties(String property, int costProperty, int rentalProperty, int[] rentalHousesAndHotel, int costHousesAndHotel, int mortgage, int numSquare, int typeSquare, String imageView, int family, int amountFamily, int hierarchy) {
        super(numSquare, typeSquare);
        this.property = property;
        this.costProperty = costProperty;
        this.rentalProperty = rentalProperty;
        this.hotel = false;
        this.houses = 0;
        this.rentalHousesAndHotel = rentalHousesAndHotel;
        this.costHousesAndHotel = costHousesAndHotel;
        this.mortgage = mortgage;
        this.owner = null;
        this.imageView = imageView;
        this.family = family;
        this.amountFamily = amountFamily;
        this.hierarchy = hierarchy;
    }

    public Properties(String property, int costProperty, int rentalProperty, int numSquare, int typeSquare, int mortgage, String imageView){ 
        super(numSquare, typeSquare);
        this.property = property;
        this.costProperty = costProperty;
        this.rentalProperty = rentalProperty;
        this.mortgage = mortgage;
        this.imageView = imageView;

    }

    public Properties(String property, int costProperty, int numSquare, int typeSquare, int mortgage, String imageView){ 
        super(numSquare, typeSquare);
        this.property = property;
        this.costProperty = costProperty;
        this.mortgage = mortgage;
        this.imageView = imageView;

    }

    public Properties(){}



    public String getProperty() {
        return this.property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getImageView() {
        return this.imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }

    public Player getOwner() {
        return this.owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getCostProperty() {
        return this.costProperty;
    }

    public void setCostProperty(int costProperty) {
        this.costProperty = costProperty;
    }

    public int getRentalProperty() {
        return this.rentalProperty;
    }

    public void setRentalProperty(int rentalProperty) {
        this.rentalProperty = rentalProperty;
    }

    public int getHouses() {
        return this.houses;
    }

    public void setHouses(int houses) {
        this.houses = houses;
    }

    public boolean isHotel() {
        return this.hotel;
    }

    public boolean getHotel() {
        return this.hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public int getCostHousesAndHotel() {
        return this.costHousesAndHotel;
    }

    public void setCostHousesAndHotel(int costHousesAndHotel) {
        this.costHousesAndHotel = costHousesAndHotel;
    }

    public int[] getRentalHousesAndHotel() {
        return this.rentalHousesAndHotel;
    }

    public void setRentalHousesAndHotel(int[] rentalHousesAndHotel) {
        this.rentalHousesAndHotel = rentalHousesAndHotel;
    }

    public int getMortgage() {
        return this.mortgage;
    }

    public void setMortgage(int mortgage) {
        this.mortgage = mortgage;
    }

    public int getFamily() {
        return this.family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public int getAmountFamily() {
        return this.amountFamily;
    }

    public void setAmountFamily(int amountFamily) {
        this.amountFamily = amountFamily;
    }

    public int getHierarchy() {
        return this.hierarchy;
    }

    public void setHierarchy(int hierarchy) {
        this.hierarchy = hierarchy;
    }
   

   
    public Properties propeties(Board board, int index){
        return board.getPropertiesSquare().get(index);
    }
    
}
