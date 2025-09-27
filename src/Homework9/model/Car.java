package Homework9.model;

import Homework9.repository.CarRepositoryImpl;

public class Car {
    protected final String number;
    protected final String model;
    protected final String color;
    private final int mileage;
    private final int price;

    public Car(String number, String model, String color, int mileage, int price){
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getMileage() {
        return mileage;
    }

    public int getPrice() {
        return price;
    }

    public String toString(){
        return  "\n" + this.number + "|" +
                this.model + "|" +
                this.color + "|" +
                this.mileage + "|" +
                this.price;
    }
}
