package com.jas.buffer;

import java.nio.ByteBuffer;

/**
 * Created by Administrator on 2017/12/18.
 */
public class API {
    public static void main(String[] args) {
        //创建一个字节缓冲区大小为256
        ByteBuffer buffer = ByteBuffer.allocate(256);
        System.out.println(buffer);
        //包装的方法创建的缓冲区保留了被包装数组内保存的数据
        buffer = ByteBuffer.wrap("sarqwer".getBytes());
        System.out.println(buffer);
        byte b = buffer.get();
        System.out.println(buffer+""+(char)b);
        //把position索引赋给limit,position索引设为0，mark设为-1
        buffer.flip();
        System.out.println(buffer);
        // 	position = 0;limit = capacity;mark = -1; 这个方法实际上也不会改变缓冲区的数据,而只是简单的重置了缓冲区的主要索引值
        buffer.clear();
        //返回limit和position之间相对位置差
        buffer.remaining();
        //position < limit返回是否还有未读内容
        buffer.hasRemaining();
        //从position位置读取一个byte，并将position+1，为下次读写作准备
        b = buffer.get();
        //绝对读，读取byteBuffer底层的bytes中下标为index的byte，不改变position
        b = buffer.get(2);
        //get(byte[] dst, int offset, int length)从position位置开始相对读，读length个byte，并写入dst下标从offset到offset+length的区域
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes,0,buffer.remaining());
        System.out.println(new String(bytes));
        System.out.println(buffer);
        buffer.flip();
        //相对写，向position的位置写入一个byte，并将postion+1，为下次读写作准备
        buffer.put(Byte.valueOf("13"));
        //	绝对写，向byteBuffer底层的bytes中下标为index的位置插入byte b，不改变position
        buffer.put(5,Byte.valueOf("16"));
        //	put(ByteBuffer src)用相对写，把src中可读的部分（也就是position到limit）写入此byteBuffer
        buffer.clear();
        buffer.put(ByteBuffer.wrap("1334".getBytes()));
        System.out.println(buffer);
        //put(byte[] src, int offset, int length)从src数组中的offset到offset+length区域读取数据并使用相对写写入此byteBuffer
        buffer.flip();
        buffer.put(new byte[]{1,2,34,5},0,4);
        System.out.println(buffer);
    }
}
