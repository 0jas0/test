package com.jas.test;

public class test2 {
    public static void main(String[] args) {
        // java的浮点类型使用二进制表示的，所有表示0.1时会失去精度
        //System.out.println(0.9-0.8);
        // <<n 右移动 相当与乘 2的n次方, >> 和 >>>都是左移动 想当如 除2的n次方，区别时 >> 高位用符号位填充高位 >>> 高位用0填充
        int i = -8>>2;
        System.out.println(i);
    }
}
