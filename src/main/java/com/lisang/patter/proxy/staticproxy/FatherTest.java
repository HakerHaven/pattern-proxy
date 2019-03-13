package com.lisang.patter.proxy.staticproxy;

/**
 * Create by lisang on 2019/3/10 10 21:06.
 */
public class FatherTest {
    public static void main(String[] args){
        Father father = new Father(new Son());
        father.findLove();

        //静态代理的形式应用
        //对数据库进行分库分表
        //ThreadLocal
        //进行数据源的动态切换
    }
}
