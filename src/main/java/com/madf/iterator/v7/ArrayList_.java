package com.madf.iterator.v7;

public class ArrayList_<E> implements Collection_<E> {
    E[] objects = (E[]) new Object[10];

    //objects中下一个空的位置在哪，或者说，目前容器中有多少个元素
    private int index = 0;

    @Override
    public void add(E o) {
        if (index == objects.length) {
            E[] newObjects = (E[]) new Object[objects.length*2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index] = o;
        index ++;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public Iterator_ iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator_ {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if (currentIndex >= index) return false;
            return true;
        }

        @Override
        public E next() {
            E o = objects[currentIndex];
            currentIndex ++;
            return o;
        }
    }
}
