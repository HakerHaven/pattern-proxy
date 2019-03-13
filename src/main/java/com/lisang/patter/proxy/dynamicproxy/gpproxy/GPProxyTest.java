package com.lisang.patter.proxy.dynamicproxy.gpproxy;

import com.lisang.patter.proxy.Person;
import com.lisang.patter.proxy.dynamicproxy.jdkproxy.Girl;

/**
 * Create by lisang on 2019/3/11 11 20:30.
 */
public class GPProxyTest {
    public static void main(String[] args) {
        try {
            //JDK实现动态代理
            Person obj = (Person) new GPMeipo().getInstance(new Girl());
            System.out.println(obj.getClass());

            obj.findLove();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
