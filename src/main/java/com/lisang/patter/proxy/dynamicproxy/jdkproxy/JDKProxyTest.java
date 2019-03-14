package com.lisang.patter.proxy.dynamicproxy.jdkproxy;

import com.lisang.patter.proxy.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Method;

/**
 * Create by lisang on 2019/3/11 11 20:17.
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        try {
            //Person obj = (Person) new JDKMeipo().getInstance(new Girl());
            //obj.findLove();
            Object obj = new JDKMeipo().getInstance(new Girl());
            System.out.println(obj.getClass());
            Method method = obj.getClass().getMethod("findLove",null);
            method.invoke(obj);

            //$Proxy0
            //byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
            //FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
            //os.write(bytes);
            //os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
