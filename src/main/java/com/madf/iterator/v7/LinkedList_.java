package com.madf.iterator.v7;

public class LinkedList_<E> implements Collection_<E> {
    private class Node {
        private E o;
        Node next;

        public Node(E o) {
            this.o = o;
        }
    }

    Node head = null;
    Node tail = null;

    //目前容器有多少个元素
    private int size = 0;

    @Override
    public void add(E o) {
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
        return size;
    }

    @Override
    public Iterator_ iterator() {
        return null;
    }
}
