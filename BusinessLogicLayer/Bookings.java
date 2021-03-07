package BusinessLogicLayer;

import java.util.LinkedList;

import DataAccessLayer.DBConnection;

import java.util.*; 

public class Bookings extends Event {

    private String BookingID;
    private String type; // Event type  
    private float price; // Price for the specific event type in addition to venue costs
    private List<Food> foodList = new LinkedList<Food>(); //List of food, will function as normal List<>
    int adultMeals = 0;
    int kidsMeals =0;
    int drinks =0;
    int desserts =0;
    Boolean Decor = false;
    Boolean confirmed = false; // to confirm an event date, may be done in database 
    //Event day must be set elswere (Or in database) when confirming the event

    DBConnection dbc;

    public Bookings(Venue eventVenue, int people, float price, String type) {
        super(eventVenue, people);
        this.price = price;
        this.type = type;
    }
    
    //Calculates, sets and returns the total Price
    public float calculatePrice(){
        this.finalPrice = this.basePrice + this.price; //Venue price + Event Price
        int i = 0;
        float foodPrice = 0;
        float adultFoodPrice = 0;

        while(i< foodList.size())
        {
            foodPrice += foodList.get(i).getMealPrice();
            if (foodList.get(i).getMealType().equalsIgnoreCase("Adult"))
            {
                adultMeals ++;
                adultFoodPrice += foodList.get(i).getMealPrice();
            }

            if (foodList.get(i).getMealType().equalsIgnoreCase("Kids"))
            {
                kidsMeals ++;
            }

            if (foodList.get(i).getMealType().equalsIgnoreCase("Drinks"))
            {
                drinks ++;
            }

            if (foodList.get(i).getMealType().equalsIgnoreCase("Dessert"))
            {
                desserts ++;
            }
        }
        this.finalPrice += foodPrice;
        if (checkPeople(people))
        {
            this.finalPrice = (float) (finalPrice - adultFoodPrice * 0.15); // 15% discount if 40+ people
        }

        if (Decor)
        {
            this.finalPrice = finalPrice +500; //set testing price for decorations
            this.finalPrice = (float) (finalPrice - 500 + this.decorations.getDecorPrice()); //will use this if decor class is kept
        }

        if (this.confirmed.equals(true))
        {
            this.finalPrice = (float) (finalPrice*0.5); // 50% off if confirmed, 15 days or more calculated in the Event class
        }

        return this.finalPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Food> getFoodList() {
        
        return foodList;
    }

    public void setFoodList(List<Food> foodList) throws ClassNotFoundException{
        foodList = dbc.getFood();
        this.foodList = foodList;
    }

    public Boolean getDecor() {
        return Decor;
    }

    public void setDecor(Boolean decor) {
        Decor = decor;
    }

    public String getBookingID() {
        return BookingID;
    }

    public void setBookingID(String bookingID) {
        BookingID = bookingID;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        confirmed = confirmed;
    }

    public Bookings(String type, float price) {
        super();
        this.type = type;
        this.price = price;
    }

    public Bookings() {
        super();
    }   
}