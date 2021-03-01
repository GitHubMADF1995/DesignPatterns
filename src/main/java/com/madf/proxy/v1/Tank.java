package com.madf.proxy.v1;

import java.util.Random;

/**
 * 问题：想记录坦克的移动时间
 */
public class Tank implements Movable {
    /**
     * 模拟坦克移动了一段时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving claclacla....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new com.madf.proxy.v2.Tank().move();
    }
}

interface Movable {
    void move();
}
