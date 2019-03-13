package com.lisang.patter.proxy.homework.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Create by lisang on 2019/3/13 13 16:33.
 */
public class JDKICCardProxy implements InvocationHandler{
    private Object target;

    public Object getInstence(Object object) {
        this.target = object;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        Object obj = method.invoke(proxy,args);
        return obj;
    }
}
