package com.lisang.patter.proxy.staticproxy;

import com.lisang.patter.proxy.Person;

/**
 * Create by lisang on 2019/3/10 10 21:04.
 */
public class Father {
    private Son person;
    public Father(Son person){
        this.person = person;
    }
    public void findLove(){
        System.out.println("父亲物色对象");
        this.person.findLove();
        System.out.println("双方父母同意，确定关系");
    }

}
