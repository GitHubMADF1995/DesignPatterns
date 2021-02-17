package com.madf.strategy;

/**
 * 策略模式，实现比较策略的
 * @param <T>
 */
public interface Comparator<T> {
    int compare(T o1, T o2);
}
