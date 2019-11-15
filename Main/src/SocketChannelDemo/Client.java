package SocketChannelDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        System.out.println("等待连接到服务器");
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 5000));
        while (!socketChannel.finishConnect()) {

        }
        System.out.println("已经连接到了服务器");
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        buffer.put("nmsl".getBytes());
        buffer.flip();
        System.out.println("开始传输数据");
        while (buffer.hasRemaining()) {
            socketChannel.write(buffer);
        }
        System.out.println("传输数据结束");
    }
}
