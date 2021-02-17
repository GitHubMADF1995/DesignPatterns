package com.madf.factory.abstractfactory;

public class CarFactory extends AbstractFactory {
    @Override
    public Car create() {
        System.out.println("Car created!");
        return new Car();
    }
}
