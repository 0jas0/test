package com.jas.test;

/**
 * Created by Administrator on 2018/1/21.
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init");
    }
    public static final String HELLO_WORLD = "hello world";
}
