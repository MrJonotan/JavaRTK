package Attestation;

import java.util.*;
import java.util.function.BiFunction;

public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя и сумму денег в формате: 'Имя = сумма; Имя = сумма'");
        String all_persons = sc.nextLine();
        List<Person> persons = parse(all_persons, Person::new);
        System.out.println("Введите название и стоимость продукта в формате: 'название продукта = цена; название продукта = цена");
        String all_products = sc.nextLine();
        List<Product> products = parse(all_products, Product::new);
        makeAPurchase(persons, products);
    }

    private static <T>List<T> parse(String input, BiFunction<String, Integer, T> factory){
        List<T> list = new ArrayList<>();
        String[] all = input.split(";");
        for (String string : all){
            string = string.trim();
            String[] data =  string.split("=");
            list.add(factory.apply(data[0].trim(), Integer.parseInt(data[1].trim())));
        }
        return list;
    }

    private static void makeAPurchase(List<Person> persons, List<Product> products){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Имя покупателя - название товара");
        String command = sc.nextLine();
        if(command.equals("END")){
            for(Person p : persons){
                String pProducts = p.getProducts();
                System.out.println(pProducts);
            }
        }else {
            String[] values = command.split("-");
            String full_name = values[0].trim();
            String product_name = values[1].trim();
            Person person = (Person) persons.stream()
                    .filter(p -> full_name.equals(p.getFullName()))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException(full_name + " не найден"));
            Product product = (Product) products.stream()
                    .filter(p -> product_name.equals(p.getName()))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException(product_name + " не найден"));
            person.buy(product);
            makeAPurchase(persons, products);
        }
    }
}