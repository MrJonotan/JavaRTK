package Homework9.repository;

import Homework9.model.Car;

import java.util.ArrayList;
import java.util.List;

public interface CarRepository<E, T> {
    T colorToFind(E elements, String color);
    int uniqueAuto(E elements, int from, int to);
    String lowerCoast(E elements);
    float modelToFind(E elements, String model);
}
