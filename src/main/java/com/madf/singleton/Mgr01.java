package com.madf.singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全（因JVM保证每一个Class只会load到内存一次）
 * 简单实用，推荐
 * 唯一缺点：不管用到与否，类加载时就完成实例化
 */
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    //无参构造方法new不出来
    private Mgr01() {}

    public static Mgr01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);
    }
}
