package com.lisang.patter.proxy.dbroute;

/**
 * Create by lisang on 2019/3/11 11 17:28.
 */
public class OrderDao {
    public int insert(Order order){
        System.out.println("OrderDao创建Order成功");
        return 1;
    }
}
