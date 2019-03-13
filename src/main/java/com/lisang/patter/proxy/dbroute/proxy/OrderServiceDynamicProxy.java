package com.lisang.patter.proxy.dbroute.proxy;

import com.lisang.patter.proxy.dbroute.IOrderService;
import com.lisang.patter.proxy.dbroute.Order;
import com.lisang.patter.proxy.dbroute.db.DynamicDataSourceEntity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by lisang on 2019/3/10 10 21:16.
 */
public class OrderServiceDynamicProxy implements InvocationHandler {
    private SimpleDateFormat year = new SimpleDateFormat("yyyy");
    Object proxyObj;
    public Object getInstance(Object proxyObj) {
        this.proxyObj = proxyObj;
        Class<?> clazz = proxyObj.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        after(args[0]);
        Object obj=method.invoke(proxyObj,null);
        return obj;
    }
    private void before(Object target){
        try {
            Long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
            Integer dbRouter = Integer.valueOf(year.format(new Date(time)));
            System.out.println("静态代理类自动分配到【DB_" +  dbRouter + "】数据源处理数据" );
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private void after(Object obj){
        // 还原默认数据
        DynamicDataSourceEntity.restore();
    }
}
