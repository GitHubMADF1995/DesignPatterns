package com.madf.singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来了线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降
 * 视图通过减小同步代码块的方式提高效率，但是不可行
 * 解决办法：双重检查判断
 */
public class Mgr06 {
    private static volatile Mgr06 INSTANCE;//如果不加volatile，会在没有初始化时就会返回这个INSTANCE实例
    //加了volatile可以防止指令重排，在线程间可见

    private Mgr06() {}

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr06.class) {
                //双重检查
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }
}
