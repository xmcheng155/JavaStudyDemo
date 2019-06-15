package com.mystudy.socket.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class SoutChannelHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        ctx.channel().writeAndFlush("ssssss");
        try{
            if(in.readBoolean()){
                System.out.println(in.toString(CharsetUtil.US_ASCII));
            }
        }finally {
            ((ByteBuf) msg).release();
        }
    }
}
