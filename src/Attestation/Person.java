package Attestation;

import java.util.ArrayList;

public class Person {
    private String fullName;
    private int cash;
    public ArrayList<String> productsPackage = new ArrayList<>();

    Person(String fullName, int cash){
        setFullName(fullName);
        setCash(cash);
    }

    public String getFullName(){
        return this.fullName;
    }

    public int getCash(){
        return this.cash;
    }

    public void setFullName(String fullName){

        if(fullName.length() < 3){
            throw new IllegalArgumentException("Имя не может быть короче 3 символов");
        }
        this.fullName = fullName;
    }

    public void setCash(int cash){
        if(cash < 0){
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.cash = cash;
    }

    public void buy(Product product){
        if(this.cash - product.getPrice() > 0){
            this.cash -= product.getPrice();
            System.out.println(this.fullName + " купил " + product.getName() + " Остаток: " + this.cash);
            productsPackage.add(product.getName());
        }else{
            System.err.println(this.fullName + " не может позволить себе " + product.getName());
        }
    }

    public String getProducts(){
        if(!this.productsPackage.isEmpty()) {
            return this.fullName + " - " + String.join(", ", this.productsPackage);
        }else{
            return this.fullName + " - Ничего не куплено";
        }
    }
}
