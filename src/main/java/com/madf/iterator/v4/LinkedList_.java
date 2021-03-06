package com.madf.iterator.v4;

public class LinkedList_ implements Collection_ {
    private class Node {
        private Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }

    Node head = null;
    Node tail = null;

    //目前容器有多少个元素
    private int size = 0;

    @Override
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

    @Override
    public int size() {
        return 0;
    }
}
