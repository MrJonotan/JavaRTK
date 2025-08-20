package Attestation;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private String fullName;
    private double cash;
    public ArrayList<String> productsPackage = new ArrayList<>();

    Person(String fullName, double cash){
        setFullName(fullName);
        setCash(cash);
    }

    public String getFullName(){
        return this.fullName;
    }

    public double getCash(){
        return this.cash;
    }

    public void setFullName(String fullName){
        if(fullName.length() < 3){
            throw new IllegalArgumentException("Имя не может быть короче 3 символов");
        }
        this.fullName = fullName;
    }

    public void setCash(double cash){
        if(cash < 0){
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.cash = cash;
    }

    public void buy(Product product){
        if(this.cash - product.getPrice() > 0){
            this.cash -= product.getPrice();
            productsPackage.add(product.getTitle());
            System.out.println(this.fullName + " купил " + product.getTitle() + " Остаток: " + this.cash);
        }else{
            System.err.println(this.fullName + " не может позволить себе " + product.getTitle());
        }
    }

    public String toString(){
        if(!this.productsPackage.isEmpty()) {
            return this.fullName + " - " + String.join(", ", this.productsPackage);
        }else{
            return this.fullName + " - Ничего не куплено";
        }
    }

    public int HashCode() {
        return Objects.hash(fullName, cash);
    }

    public boolean equals(Object object){
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return Objects.equals(fullName, person.fullName) && Objects.equals(cash, person.cash);
    }
}
