package com.jas.multi;

/**
 * Created by Administrator on 2017/12/14.
 */
public class volatileTest {
    //不加volatile出现死循环
    //public static volatile int num;
    public static  int num;
    //public static volatile boolean bool = false;
    public static  boolean bool = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bool = true;
                num = 10;
                System.out.println("t1线程结束了");
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!bool){
                }
                System.out.println("t2线程结束了"+num);
            }
        });
        t2.start();
    }
}
