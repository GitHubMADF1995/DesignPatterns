package com.madf.iterator.v2;

/**
 * 使用链表构建一个容器，可以添加对象
 */
public class Main {
    public static void main(String[] args) {
        LinkedList_ list = new LinkedList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s" + i));
        }
        System.out.println(list.size());
    }
}

/**
 * 相比数组，这个容易不用考虑边界问题，可以动态扩展
 */
class LinkedList_ {
    Node head = null;
    Node tail = null;

    //目前容器有多少个元素
    private int size = 0;

    public void add(Object o) {
        Node n = new Node(o);
        n.next = null;

        if (head == null) {
            head = n;
            tail = n;
        }

        tail.next = null;
        tail = n;
        size++;
    }

    private class Node {
        private Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }

    public int size() {
        return size;
    }
}