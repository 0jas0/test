package com.jas.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by Administrator on 2017/12/17.
 */
public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel,AsyncServerHandler>{
    /**
     * 客户端连接成功的方法
     * @param attachment
     */
    @Override
    public void completed(AsynchronousSocketChannel channel, AsyncServerHandler attachment) {
        server.countClient.addAndGet(1);
        System.out.println("连接的客户端数：" + server.countClient.get());
        //让其他的客户端继续执行
        attachment.channel.accept(attachment,this);
        //创建新的Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //异步读  第三个参数为接收消息回调的业务Handler
        channel.read(buffer,buffer,new ReadHandler(channel));
    }

    /**
     * 客户端连接失败的处理
     * @param exc
     * @param attachment
     */
    @Override
    public void failed(Throwable exc, AsyncServerHandler attachment) {
        exc.printStackTrace();
        AsyncServerHandler.latch.countDown();
    }
}
