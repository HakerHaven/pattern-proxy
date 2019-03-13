package com.lisang.patter.proxy.dynamicproxy.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * Create by lisang on 2019/3/11 11 21:18.
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        try {
            //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"E://cglib_proxy_classes");
            Customer customer = (Customer) new CglibMeipo().getInstance(Customer.class);
            System.out.println(customer);
            customer.findLove();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
