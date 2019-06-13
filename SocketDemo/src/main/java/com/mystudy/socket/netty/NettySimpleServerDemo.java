package com.mystudy.socket.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class NettySimpleServerDemo {
    private static EventLoopGroup bossGroup = new NioEventLoopGroup(4);
    private static EventLoopGroup workerGroup = new NioEventLoopGroup(20 );
    private static int port = 8899;


    public static void main(String[] args) {
        BasicConfigurator.configure();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ChannelPipeline channelPipeline = ch.pipeline();
                        //channelPipeline.addLast("deCode",new HttpServerCodec());
                        channelPipeline.addLast("sout",new SoutChannelHandler());
                    }
                });
        try {
            serverBootstrap.bind(port).sync().addListener(future ->{
                if(future.isSuccess()){
                    System.out.println("端口绑定成功");
                }
            }).channel().closeFuture().addListener(future -> {
                if(future.isSuccess()){
                    System.out.println("端口g");
                }
            }).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
