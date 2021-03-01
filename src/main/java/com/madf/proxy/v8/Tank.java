package com.madf.proxy.v8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * 问题：想记录坦克的移动时间
 * 最简单的办法：修改代码，记录时间
 * 问题2：如果无法改变方法源码呢？
 * 用继承？————>慎用继承
 * 使用代理模式
 * 代理有各种类型
 * 问题：如何实现代理的各种组合？继承？Decorator？
 * 代理的对象改成Movable类型，越来越像decorator了
 * 如果想让LogProxy方法可以重用，不仅可以代理坦克，还可以代理任何其他代理的类型（毕竟日志记录时间计算是很多方法都需要的东西），这时该怎么做？
 * 分离代理行为与被代理对象
 * 使用jdk的动态代理
 *
 * 横切代码与业务逻辑代码分离 AOP
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
        Movable m = (Movable) Proxy.newProxyInstance(
                Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new TimeHandle(new Tank()));
        m.move();
    }
}

class TimeHandle implements InvocationHandler {
    Movable m;

    public TimeHandle(Movable m) {
        this.m = m;
    }

    public void before() {
        System.out.println("method start...");
    }

    public void after() {
        System.out.println("method stopped...");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(m, args);
        after();
        return o;
    }
}

interface Movable {
    void move();
}
