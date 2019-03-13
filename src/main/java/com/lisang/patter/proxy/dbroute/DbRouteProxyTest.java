package com.lisang.patter.proxy.dbroute;

import com.lisang.patter.proxy.dbroute.proxy.OrderServiceDynamicProxy;
import com.lisang.patter.proxy.dbroute.proxy.OrderServiceStaticProxy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by lisang on 2019/3/11 11 17:34.
 */
public class DbRouteProxyTest {
    public static void main(String[] args) {
        try {
            Order order = new Order();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2017/10/21");
            System.out.println(date);
            order.setCreateTime(date.getTime());
            //IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
            IOrderService orderService = (IOrderService)new OrderServiceDynamicProxy().getInstance(new OrderService());
            orderService.createOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
