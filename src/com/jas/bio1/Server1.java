package com.jas.bio1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/12/17.
 */
public class Server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        Socket socket = server.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        String expression;
        while((expression = in.readLine())!=null){
            System.out.println(expression);
        }
        socket.close();
        server.close();
    }
}
