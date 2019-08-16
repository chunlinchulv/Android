package com.example.bluechat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class Server {
    public static ArrayList<Socket> asocket = new ArrayList<>() ;
    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(11111);
            while (true){
                Socket s = ss.accept();
                System.out.println("ip:"+ s.getInetAddress().getHostAddress() +"加入聊天室");
                asocket.add(s);
                new Thread(new ServerThread(s)).start();
            }
        }catch (IOException e){
            e.printStackTrace();
            e.printStackTrace();

        }
    }
}
class ServerThread implements Runnable {
    Socket socket;
    InputStream receive;
    OutputStream send;

    public ServerThread(Socket s) {
        this.socket = s;
    }
    public void run(){
        try {
            int len;
            byte[] b = new byte[1024 * 8];
            receive = socket.getInputStream();
            send = socket.getOutputStream();
            while ((len = receive.read(b)) != -1){
                String line = new String(b,0,len) + "\n";
                for (Iterator<Socket> it = Server.asocket.iterator(); it.hasNext();) {
                    Socket sh = it.next();
                    try {
                        if (sh.equals(socket)) {
                            continue;
                        }
                        OutputStream outputStream = sh.getOutputStream();
                        outputStream.write(line.getBytes());
                    } catch (Exception e) {
                        e.printStackTrace();
                        it.remove();
                    }
                }
            }
        }catch (IOException e){
            System.out.println("接收出错");
            e.printStackTrace();
        }
        Server.asocket.remove(socket);
        System.out.println("ip:"+ socket.getInetAddress().getHostAddress() +"退出聊天室");
    }
}
