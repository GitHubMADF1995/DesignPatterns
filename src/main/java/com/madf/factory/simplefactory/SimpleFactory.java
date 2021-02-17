package com.madf.factory.simplefactory;

/**
 * 简单工厂的可扩展性不好
 */
public class SimpleFactory {
    public Car createCar() {
        //before processing
        return new Car();
    }

    public Plane createPlane() {
        return new Plane();
    }
}
