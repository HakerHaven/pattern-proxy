package com.lisang.patter.proxy.dynamicproxy.gpproxy;

import java.lang.reflect.Method;

/**
 * Create by lisang on 2019/3/11 11 20:27.
 */
public interface GPInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
