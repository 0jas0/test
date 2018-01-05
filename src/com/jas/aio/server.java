package com.jas.aio;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/12/17.
 */
public class server {
    private static int DEFAULT_PORT =12345;
    private static AsyncServerHandler serverHandle;
    public static AtomicInteger countClient = new AtomicInteger(0);
    public static void start(){
        start(DEFAULT_PORT);
    }
    public static synchronized void start(int port){
        if(serverHandle!=null)
            return;
        serverHandle = new AsyncServerHandler(port);
        new Thread(serverHandle,"Server").start();
    }
}
