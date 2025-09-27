package Homework9.test;

import Homework9.model.Car;
import Homework9.repository.CarRepositoryImpl;
import Homework9.repository.TxtLogger;
import Homework9.repository.Logger;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Car> Cars = new ArrayList<Car>();
        Cars.add(new Car("a123me", "Mercedes", "White", 0, 8300000));
        Cars.add(new Car("b873of", "Volga", "Black", 0, 673000));
        Cars.add(new Car("w487mn", "Lexus", "Grey", 76000, 900000));
        Cars.add(new Car("p987hj", "Volga", "Red", 610, 704340));
        Cars.add(new Car("c987ss", "Toyota", "White", 254000, 761000));
        Cars.add(new Car("o983op", "Toyota", "Black", 698000, 740000));
        Cars.add(new Car("p146op", "BMW", "White", 271000, 850000));
        Cars.add(new Car("u893ii", "Toyota", "Purple", 210900, 440000));
        Cars.add(new Car("l097df", "Toyota", "Black", 108000, 780000));
        Cars.add(new Car("y876wd", "Toyota", "Black", 160000, 1000000));

        CarRepositoryImpl cri = new CarRepositoryImpl();
        Logger txtLogger = new TxtLogger("src/Homework9/data/cars");

        txtLogger.log("Автомобили в базе \nНомер|Модель|Цвет|Пробег|Цена" + Cars + "\n");
        txtLogger.log("Номера автомобилей по цвету или пробегу:" + cri.colorToFind(Cars, "Black").toString() + "\n");
        txtLogger.log("Уникальные автомобили: " + cri.uniqueAuto(Cars, 700000, 800000) + " шт" + "\n");
        txtLogger.log("Цвет автомобиля с минимальной стоимостью: " + cri.lowerCoast(Cars) + "\n");
        txtLogger.log("Средняя стоимость модели Toyota: " + cri.modelToFind(Cars, "Toyota") + "\n");
        txtLogger.log("Средняя стоимость модели Volvo: " + cri.modelToFind(Cars, "Volvo"));

        System.out.println("Автомобили в базе");
        System.out.println("Номер|Модель|Цвет|Пробег|Цена");
        Cars.forEach(System.out::println);
        System.out.println("Номера автомобилей по цвету или пробегу:" + cri.colorToFind(Cars, "Black").toString());
        System.out.println("Уникальные автомобили: " + cri.uniqueAuto(Cars, 700000, 800000) + " шт");
        System.out.println("Цвет автомобиля с минимальной стоимостью: " + cri.lowerCoast(Cars));
        System.out.println("Средняя стоимость модели Toyota: " + cri.modelToFind(Cars, "Toyota"));
        System.out.println("Средняя стоимость модели Volvo: " + cri.modelToFind(Cars, "Volvo"));

    }
}
