package com.madf.proxy.spring.v2;

import com.madf.proxy.spring.v1.Tank;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring aop test
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app_auto.xml");
        Tank tank = (Tank)context.getBean("tank");
        tank.move();
    }
}
