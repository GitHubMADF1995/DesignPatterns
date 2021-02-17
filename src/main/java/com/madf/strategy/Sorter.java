package com.madf.strategy;

import java.util.Arrays;

public class Sorter<T> {

    private void sort1(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
            }

            swap((T[]) arr, i, minPos);
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void sort2(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = comparator.compare(arr[j], arr[minPos]) == -1 ? j : minPos;
            }

            swap(arr, i, minPos);
        }
    }

    public static void main(String[] args) {
        //关于comparable方法的比较
        Cat[] a = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};
        Sorter<Cat> sorter = new Sorter<>();
//        sorter.sort1(a);
//        System.out.println(Arrays.toString(a));

        //关于comparator比较器的比较
        sorter.sort2(a, new CatComparator());
        sorter.sort2(a, (o1, o2) -> {
            if (o1.weight < o2.weight) return -1;
            else if (o1.weight > o2.weight) return 1;
            else return 0;
        });
        System.out.println(Arrays.toString(a));
    }

}
