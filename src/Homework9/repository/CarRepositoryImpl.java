package Homework9.repository;

import Homework9.model.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class CarRepositoryImpl implements CarRepository<ArrayList<Car>, Set<String>> {

    @Override
    public Set<String> colorToFind(ArrayList<Car> Cars, String color) {
        return  Cars.stream()
                .filter(e -> e.getColor().equals(color) || e.getMileage() == 0)
                .map(Car::getNumber)
                .collect(Collectors.toSet());
    }

    @Override
    public int uniqueAuto(ArrayList<Car> Cars, int from, int to) {
        return Math.toIntExact(Cars.stream()
                .filter(e -> e.getPrice() > from && e.getPrice() < to)
                .count());
    }

    @Override
    public String lowerCoast(ArrayList<Car> Cars) {
        return Cars.stream()
                .min(Comparator.comparing(Car::getPrice))
                .map(Car::getColor)
                .get();
    }

    @Override
    public float modelToFind(ArrayList<Car> Cars, String model) {
        return (float) Cars.stream()
                .filter(e -> e.getModel().equals(model))
                .mapToInt(Car::getPrice)
                .average()
                .orElse(0);
    }
}
