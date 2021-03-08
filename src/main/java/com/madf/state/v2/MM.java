package com.madf.state.v2;

/**
 * 当增加新的状态时非常不方便
 */

public class MM {
    String name;
    MMState state = new MMHappyState();

    public void smile() {
        state.smile();
    }

    public void cry() {
        state.cry();
    }

    public void say() {
        state.say();
    }

    public static void main(String[] args) {
        MM mm = new MM();
        mm.smile();
    }

}
