package com.lisang.patter.proxy.homework.staticproxy;

/**
 * Create by lisang on 2019/3/13 13 16:26.
 */
public class ICCardImpl implements ICCard {
    @Override
    public void pay() {
        System.out.println("you can pay for it!");
    }
}
