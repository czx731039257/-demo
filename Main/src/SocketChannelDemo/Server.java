package SocketChannelDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(5000));
        System.out.println("等待用户进来");
        SocketChannel socketChannel = serverSocketChannel.accept();
        System.out.println("有用户进来了");
        Thread.sleep(5000);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        socketChannel.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println((char) buffer.get());
        }
    }
}
