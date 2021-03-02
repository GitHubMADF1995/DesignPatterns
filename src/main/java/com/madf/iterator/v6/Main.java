package com.madf.iterator.v6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * JDK的容器的Iterator
 */
public class Main {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        for (int i = 0; i < 15; i++) {
            c.add(new String("s" + i));
        }

        Iterator it = c.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            System.out.println(o);
        }
    }
}
