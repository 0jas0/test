package com.jas.test;

import com.jas.jdkProxy.InvocationHandlerImpl;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/9.
 */
public class Test implements IHello{
    public int a;

    public Test(int a) {
        this.a = a;
    }

    public void add(Test t){
        t = new Test(t.a+1);
    }

    public void sayHello(int i){
        System.out.println("hello");
    }

    public static void main(String[] args) {
        final Test t = new Test(5);
        //t.add(t);
        //System.out.println(t.a);
        //System.out.println(ConstClass.HELLO_WORLD);

        IHello obj = (IHello)Proxy.newProxyInstance(Test.class.getClassLoader(), Test.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("sayHello".equals(method.getName())){
                    System.out.println("代理了"+args[0].toString());
                    Object invoke = method.invoke(t,args);
                    return invoke;
                }
                return method.invoke(t,args);
            }
        });
        obj.sayHello(5);
    }
}
