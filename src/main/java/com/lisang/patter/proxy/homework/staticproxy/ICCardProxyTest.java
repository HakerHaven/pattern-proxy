package com.lisang.patter.proxy.homework.staticproxy;

import com.lisang.patter.proxy.homework.dynamicproxy.CglibICCardProxy;
import com.lisang.patter.proxy.homework.dynamicproxy.JDKICCardProxy;

import java.lang.reflect.Method;

/**
 * Create by lisang on 2019/3/13 13 16:30.
 */
public class ICCardProxyTest {
    public static void main(String[] args) {
        ICCardProxy icCardProxy = new ICCardProxy(new ICCardImpl());
        icCardProxy.pay();

        try {
            Object obj=new JDKICCardProxy().getInstence(new ICCardImpl());
            Method method = obj.getClass().getMethod("pay",null);
            method.invoke(obj);


            ICCardImpl icCardImpl = (ICCardImpl)new CglibICCardProxy().getInstence(ICCardImpl.class);
            icCardImpl.pay();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
