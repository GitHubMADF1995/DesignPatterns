package com.madf.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * CGLIB实现动态代理接口不需要接口：底层用的也是ASM
 */
public class Main {
    public static void main(String[] args) {
        //增强器
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodInterceptor());//设置回调，相当于InvocationHandler
        Tank tank = (Tank) enhancer.create();//动态代理类生成
        tank.move();
    }
}

class TimeMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(o.getClass().getSuperclass().getName());
        System.out.println("before");
        Object result = null;
        result = methodProxy.invokeSuper(o, objects);
        System.out.println("after");
        return result;
    }
}

class Tank {
    public void move() {
        System.out.println("Tank moving calcalcal......");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}