package com.lisang.patter.proxy.dynamicproxy.gpproxy;

import com.lisang.patter.proxy.Person;

import java.lang.reflect.Method;

/**
 * Create by lisang on 2019/3/11 11 18:44.
 */
public class GPMeipo implements GPInvocationHandler {
    private Person target;
    public Object getInstance(Person person) throws Exception{
        this.target = person;
        Class<?> clazz = target.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target,args);
        after();
        return obj;
    }

    private void before(){
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }

    private void after(){
        System.out.println("OK的话，准备办事");
    }
}
