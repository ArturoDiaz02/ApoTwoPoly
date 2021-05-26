package model.objects;

import javafx.scene.image.ImageView;

public class Properties extends Square{
    
    private ImageView property;
    private int costProperty;
    private int rentalProperty;
    private int[][] housesAndHotel;
    private int[] costHousesAndHotel;
    private int mortgage;


    public Properties(ImageView property, int costProperty, int rentalProperty, int[][] housesAndHotel, int[] costHousesAndHotel, int mortgage, int numSquare, int typeSquare) {
        super(numSquare, typeSquare);
        this.property = property;
        this.costProperty = costProperty;
        this.rentalProperty = rentalProperty;
        this.housesAndHotel = housesAndHotel;
        this.costHousesAndHotel = costHousesAndHotel;
        this.mortgage = mortgage;
    }

    
    public ImageView getProperty() {
        return this.property;
    }

    public void setProperty(ImageView property) {
        this.property = property;
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

    public int[][] getHousesAndHotel() {
        return this.housesAndHotel;
    }

    public void setHousesAndHotel(int[][] housesAndHotel) {
        this.housesAndHotel = housesAndHotel;
    }

    public int[] getCostHousesAndHotel() {
        return this.costHousesAndHotel;
    }

    public void setCostHousesAndHotel(int[] costHousesAndHotel) {
        this.costHousesAndHotel = costHousesAndHotel;
    }

    public int getMortgage() {
        return this.mortgage;
    }

    public void setMortgage(int mortgage) {
        this.mortgage = mortgage;
    }
    
}
