package Attestation;

import java.time.LocalDate;

public class DiscountProduct extends Product{
    private final int percentDiscount;
    private final LocalDate discountValidity;
    private final double finalPrice;

    /**
     * Конструктор дочернего класса Product
     * @param title Название
     * @param price Цена
     * @param percentDiscount Процент скидки
     * @param discountValidity Дата окончания действия скидки
     */
    public DiscountProduct (String title, double price, int percentDiscount, LocalDate discountValidity){
        super(title, price);
        this.percentDiscount = setPercentDiscount(percentDiscount);
        this.discountValidity = discountValidity;
        this.finalPrice = getEffectivePrice(price);
    }

    /**
     * @param percentDiscount Процент скидки
     * @return Корректное значение скидки в процентах
     */
    public int setPercentDiscount(int percentDiscount) {
        if(percentDiscount < 0){
            throw new IllegalArgumentException("Скидка не может быть отрицательной!");
        }
        if(percentDiscount > 100){
            throw new IllegalArgumentException("Скидка не может быть больше 100%!");
        }
        return percentDiscount;
    }

    public int getPercentDiscount() { return percentDiscount; }

    public LocalDate getDiscountValidity() { return discountValidity; }

    /**
     * Проверяет актуальность даты действия скидки
     * @return логическое значение
     */
    private boolean isDiscountActive(){
        if(percentDiscount <= 0 || discountValidity == null) return false;
        LocalDate today = LocalDate.now();
        return !today.isAfter(discountValidity);
    }

    /**
     * Данный метод применяет скидку к цене товара, при условии, что скидка действительна
     * @param price цена товара
     * @return цена товара со скидкой (при ее наличии)
     */
    public double getEffectivePrice(double price) {
        if(isDiscountActive()){
            return price * (1.0 - percentDiscount / 100.0);
        }else {
            return price;
        }
    }

    @Override
    public double getPrice() {
        return finalPrice;
    }

    @Override
    public String toString(){
        return super.toString() + "\nCкидка " + percentDiscount + "% "
                + "\nЦена со скидкой: " + finalPrice
                + "\nСкидка действует до: " + discountValidity.toString();
    }
}