package com.lisang.patter.proxy.homework.staticproxy;

/**
 * Create by lisang on 2019/3/13 13 16:27.
 */
public class ICCardProxy implements ICCard {
    private ICCardImpl icCard;

    public ICCardProxy(ICCardImpl icCard) {
        this.icCard = icCard;
    }

    @Override
    public void pay() {
        this.icCard.pay();
    }
}
