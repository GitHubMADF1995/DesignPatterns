package com.madf.singleton;

/**
 * 完美中的完美
 * 不仅可以解决线程同步，还可以防止反序列化（因为枚举类没有构造方法，无法反序列化构造出实例）
 */
public enum Mgr08 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr08.INSTANCE.hashCode());
            }).start();
        }
    }
}
