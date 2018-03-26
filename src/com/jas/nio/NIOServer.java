package com.jas.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    // 缓冲区大小
    private final int SIZE = 4096;
    // 接受缓冲区数据
    private ByteBuffer readerBuffer = ByteBuffer.allocate(SIZE);
    // 发送缓冲区数据
    private ByteBuffer writerBuffer = ByteBuffer.allocate(SIZE);

    private Selector selector;

    /**
     * 初始化操作
     * @param port 端口号
     * @throws IOException
     */
    public NIOServer(int port) throws IOException {
        // 打开服务器通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置为非阻塞的
        serverSocketChannel.configureBlocking(false);
        // 检索与此通道关联的服务器套接字
        ServerSocket socket = serverSocketChannel.socket();
        // 绑定端口号
        socket.bind(new InetSocketAddress(port));
        // 通过open()方法找到selector
        selector = Selector.open();
        // 注册到selector，等待连接
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    /**
     * 监听
     */
    public void listen() throws IOException {
        while (true){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                handleKey(selectionKey);
            }

        }
    }

    /**
     * 处理请求
     * @param selectionKey
     */
    public void handleKey(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel serverSocketChannel = null;
        SocketChannel client = null;
        String readerText = null;
        String writerText = "java大法好";
        if (selectionKey.isAcceptable()){
            // 可接受状态
            serverSocketChannel =(ServerSocketChannel) selectionKey.channel();
            // 接受到此通道套接字的连接。
            // 此方法返回的套接字通道（如果有）将处于阻塞模式。
            client = serverSocketChannel.accept();
            // 配置为非阻塞
            serverSocketChannel.configureBlocking(false);
            // 注册到selector，等待连接
            client.register(selector, SelectionKey.OP_READ);
        }else if (selectionKey.isReadable()){
            // 可读状态
            // 返回为之创建此键的通道。
            client =(SocketChannel) selectionKey.channel();
            // 将readerbuffer清空以便下一次读操作
            readerBuffer.clear();
            int count = client.read(readerBuffer);
            if (count > 0){
                readerText = new String(readerBuffer.array(), 0, count);
                System.out.println("服务器接收到的数据为： " + readerText);
                client.register(selector, SelectionKey.OP_WRITE);
            }
        }else if (selectionKey.isWritable()){
            // 可写状态
            // 返回为之创建此键的通道。
            client =(SocketChannel) selectionKey.channel();
            // 将readerbuffer清空以便下一次读操作
            writerBuffer.clear();
            writerBuffer.put(writerText.getBytes());
            writerBuffer.flip();
            client.write(writerBuffer);
            System.out.println("服务器向客户端发送数据："+ writerText);
            client.register(selector, SelectionKey.OP_READ);
        }
    }

    public static void main(String[] args) throws IOException {
        int port = 8888;
        NIOServer nioServer = new NIOServer(port);
        nioServer.listen();
    }

}
