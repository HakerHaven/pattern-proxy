package com.lisang.patter.proxy.dbroute.proxy;

import com.lisang.patter.proxy.dbroute.IOrderService;
import com.lisang.patter.proxy.dbroute.Order;
import com.lisang.patter.proxy.dbroute.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by lisang on 2019/3/10 10 21:16.
 */
public class OrderServiceStaticProxy implements IOrderService {
    private SimpleDateFormat year = new SimpleDateFormat("yyyy");

    private IOrderService orderService;
    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    public int createOrder(Order order) {
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(year.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_" +  dbRouter + "】数据源处理数据" );
        DynamicDataSourceEntity.set(dbRouter);

        this.orderService.createOrder(order);
        DynamicDataSourceEntity.restore();
        return 0;
    }
}
