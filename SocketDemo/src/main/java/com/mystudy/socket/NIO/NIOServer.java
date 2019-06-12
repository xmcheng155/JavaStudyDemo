package com.mystudy.socket.NIO;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class NIOServer {
    private static int SERVER_POINT = 8899;
    private static Logger log = Logger.getLogger(NIOServer.class);


    //反应器模式
    public static class ReactorTask implements Runnable{
        private ServerSocketChannel socketChannel;

        private Selector selector;

        public ReactorTask() {
            init(SERVER_POINT);
        }

        private void init(int point) {
            try {
                socketChannel = ServerSocketChannel.open();
                socketChannel.configureBlocking(false);
                selector = Selector.open();
                socketChannel.bind(new InetSocketAddress(point), 100);
                socketChannel.register(selector, SelectionKey.OP_ACCEPT);
                log.info("服务器启动完成--------->");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
           while (true){
               try {
                   selector.select();
                   Iterator<SelectionKey> keys =  selector.selectedKeys().iterator();
                   while (keys.hasNext()){
                       SelectionKey key = keys.next();
                       keys.remove();
                       if(key.isValid()){
                           if(key.isReadable()){
                               read(key,selector);
                           }
                           if(key.isWritable()){
                               write(key,selector);
                           }
                           if(key.isAcceptable()){
                               accept(key,selector);
                           }
                       }else{
                           key.cancel();
                       }
                   }
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
    }



    private static void read(SelectionKey key,Selector selector){
        SocketChannel sc= (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        try {
            sc.configureBlocking(false);
            sc.read(buffer);
            buffer.flip();
            byte [] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
            log.info(sc.getRemoteAddress()+"收到消息---->"+new String(bytes,"UTF-8"));
            System.out.println(sc.getRemoteAddress()+"消息处理中");
            Thread.sleep(15000);
            System.out.println(sc.getRemoteAddress()+"消息处理完成");
            sc.register(selector,SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void write(SelectionKey key,Selector selector){
        SocketChannel sc= (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        try {
            sc.configureBlocking(false);
            buffer.put("Server return ".getBytes("UTF-8"));
            buffer.flip();
            sc.write(buffer);
            log.info(sc.getRemoteAddress()+"发送消息--->");
            sc.register(selector,SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void accept(SelectionKey key,Selector selector){
        ServerSocketChannel sc= (ServerSocketChannel) key.channel();
        try {
            SocketChannel channel = sc.accept();
            channel.configureBlocking(false);
            log.info(channel.getRemoteAddress()+"建立连接!");
            channel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void main(String[] args) {
        new Thread(new ReactorTask()).start();
    }

}
