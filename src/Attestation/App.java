package Attestation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;

public class App {
    public static void main(String[] args){
        System.out.println("Введите имя и сумму денег в формате: 'Имя = сумма'." +
                " Для завершения введите команду END");
        List<Person> persons = new ArrayList<>();
        getConsoleData(App::createPerson, persons);
        System.out.println("Введите название товара и стоимость в формате: " +
                "'Название продкукта = стоимость (скидка в процентах, дата " +
                "окончания дейстивя скидки)' скидка вводится опционально. Для " +
                "завершения введите команду END");
        List<Item> products = new ArrayList<>();
        getConsoleData(App::createProduct, products);
        makeAPurchase(persons, products);
    }

    /**
     * Интерфейс для выполнения функции переданной в качестве аргумента
     * @param <T>
     */
    public interface ConsoleParser<T> {
        void apply(List<T> list, String data);
    }

    /**
     * Данный метод предназначен получения данных из консоли и передачи строки в функцию для создания новых экземпляров класса
     * @param parser функция, для создания экземпляров объектов
     * @param list массив, в который будут добавлены объекты
     * @param <T>
     */
    private static <T> void getConsoleData(ConsoleParser<T> parser, List<T> list) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        if (!data.equalsIgnoreCase("end")) {
            parser.apply(list, data);
            getConsoleData(parser, list);
        }
    }

    /**
     * Данный метод разбивает полученную из консоли строку, форматирует данные и добавляет
     * новый экземпляр класса в массив
     * @param persons массив объектов, в котором хранятся экземпляры, созданные пользователем
     * @param data строка, полученная из консоли
     */
    private static void createPerson(List<Person> persons, String data){
        String[] personData = data.split("=");
        String fullName = personData[0].trim();
        double cash = Double.parseDouble(personData[1].trim());
        persons.add(new Person(fullName, cash));
    }

    /**
     * В данном методе проводится проверка полученной строки и на основе проверки
     * в массив добавляются экземпляры нужного типа
     * @param products массив с объектами типа Product и DiscountProduct
     * @param data строка, полученная из консоли
     */
    private static void createProduct(List<Item> products, String data){
        String discountData = null;
        String[] productData = data.split("\\(");
        String mainData = productData[0].trim();
        if(productData.length > 1) {
           discountData = productData[1].replace(String.valueOf(')'), "");
        }
        String[] mainDataArray = mainData.split("=");
        String title = mainDataArray[0].trim();
        double price = Double.parseDouble(mainDataArray[1].trim());
        if(discountData != null){
            String[] discountDataArray = discountData.split(",");
            int percentDiscount = Integer.parseInt(discountDataArray[0].trim());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate discountValidity = LocalDate.parse(discountDataArray[1].trim(), formatter);
            products.add(new DiscountProduct(title, price, percentDiscount, discountValidity));
        }
        products.add(new Product(title, price));
    }

    /**
     * Данный метод производит поиск объектов в массиве
     * @param list список объектов
     * @param extractor функция класса, возвращаемая искомое значение
     * @param variable значение, по которому осуществляется поиск
     * @return найденный объект
     * @param <T> Объект любого типа
     */
    private static <T> T getObjectFromList(List<? extends T> list, Function<? super T, String> extractor, String variable){
        return list.stream()
            .filter(p -> variable.equals(extractor.apply(p)))
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException(variable + " не найден"));
    }

    /**
     * Метод совершения покупок. В данном методе обрабатывается полученная из консоли строка.
     * Далее производится поиск покупателя и продукта.
     * Если в списках будут найдены и покупатель и продукт, то покупка записывается в список покупок покупателя.
     * При завершении работы данного метода циклом выводятся список покупателей и купленные ими товары.
     * @param persons Список покупателей
     * @param products Список продуктов
     */
    private static void makeAPurchase(List<Person> persons, List<Item> products){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Имя покупателя - название товара");
        String command = sc.nextLine();
        if(command.equalsIgnoreCase("end")){
            for(Person p : persons){
                String pProducts = p.toString();
                System.out.println(pProducts);
            }
            sc.close();
        }else{
            String[] values = command.split("-");
            String fullName = values[0].trim();
            String title = values[1].trim();
            Person person = getObjectFromList(persons, Person::getFullName, fullName);
            Item product = getObjectFromList(products, Item::getInfo, title);
            if (product instanceof Product) {
                person.buy((Product) product);
            } else {
                throw new IllegalArgumentException("Ожидался Product");
            }
            makeAPurchase(persons, products);
        }
    }
}