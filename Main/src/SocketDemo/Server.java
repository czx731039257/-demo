package SocketDemo;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2000);
        System.out.println("等待用户进来");
        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        char[] in = new char[1024];
        System.out.println("等待读入数据");
        int read = reader.read(in);
        System.out.println("接收到数据");
        System.out.println(String.valueOf(in));
    }
}
