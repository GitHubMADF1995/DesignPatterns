package com.madf.factory;

import com.madf.factory.abstractfactory.AbstractFactory;
import com.madf.factory.abstractfactory.CarFactory;
import com.madf.factory.simplefactory.Car;
import com.madf.factory.simplefactory.Plane;
import com.madf.factory.simplefactory.SimpleFactory;

public class Main {

    public static void main(String[] args) {
        //简单工厂
        Car car1 = new SimpleFactory().createCar();
        Plane plane = new SimpleFactory().createPlane();
        car1.go();

        //抽象工厂
        AbstractFactory abstractFactory = new CarFactory();
        com.madf.factory.abstractfactory.Car car2 = abstractFactory.create();
        car2.go();
    }

}
