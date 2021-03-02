package com.madf.iterator.v5;

/**
 * 添加容器的共同接口，实现两个容器能互相替换
 * 如何对容器进行遍历
 */
public class Main {
    public static void main(String[] args) {
//        Collection_ list = new LinkedList_();
        Collection_ list = new ArrayList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s" + i));
        }
        System.out.println(list.size());

        //这个接口的调用方式
        Iterator_ it = list.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            System.out.println(o);
        }
    }
}
