package com.madf.proxy.v6;

import java.util.Random;

/**
 * 问题：想记录坦克的移动时间
 * 最简单的办法：修改代码，记录时间
 * 问题2：如果无法改变方法源码呢？
 * 用继承？————>慎用继承
 * 使用代理模式
 * 代理有各种类型
 * 问题：如何实现代理的各种组合？继承？Decorator？
 *
 * 最基础的静态代理产生了
 */
public class Tank implements Movable {
    /**
     * 模拟坦克移动了一段时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving calcalcal......");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TankLogProxy(new TankTimeProxy(new Tank())).move();
    }
}

class TankTimeProxy implements Movable {
    Movable movable;

    public TankTimeProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        movable.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class TankLogProxy implements Movable {
    Movable movable;

    public TankLogProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        System.out.println("start moving.....");
        movable.move();
        System.out.println("stopped!");
    }
}

interface Movable {
    void move();
}
