package com.madf.proxy.v7;

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
 *
 * 分离代理行为与被代理对象
 * 使用jdk的动态代理
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
        Tank tank = new Tank();

        Movable m1 = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("method " + method.getName() + "start...");
                Object o = method.invoke(tank, args);
                System.out.println("method " + method.getName() + "end...!");
                return o;
            }
        });
        m1.move();

        Movable m2 = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new LogHandle(new Tank()));
        m2.move();
    }
}

class LogHandle implements InvocationHandler {
    Tank tank;

    public LogHandle(Tank tank) {
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method " + method.getName() + "start...");
        Object o = method.invoke(tank, args);
        System.out.println("method " + method.getName() + "end...!");
        return o;
    }
}

interface Movable {
    void move();
}
