package Attestation;

import java.util.Objects;

public class Product implements Item {
    private String title;
    private double price;

    /**
     * Конструктор класса
     * @param title Название
     * @param price Цена
     */
    Product(String title, double price){
        setTitle(title);
        setPrice(price);
    }

    public void setTitle(String title) {
        if(title.length() < 3){
            throw new IllegalArgumentException("Название продукта не может быть меньше 3 символов!");
        }
        this.title = title;
    }

    public void setPrice(double price){
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        this.price = price;
    }

    public String getTitle(){
        return this.title;
    }

    public double getPrice(){
        return this.price;
    }

    public String toString(){
        return "Название продукта: " + this.title + "\nЦена: " + this.price;
    }

    public int HashCode() {
        return Objects.hash(this.title, this.price);
    }

    public boolean equals(Object object){
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return Objects.equals(title, product.title) && Objects.equals(price, product.price);
    }

    /**
     * Реализация метода интерфейса Item
     * @return название товара, по которому производится поиск
     */
    @Override
    public String getInfo() {
        return title;
    }
}
