package com.github.taojintianxia.incubator.netty.inaction.chapter2.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author Nianjun Sun
 * @date 2019-05-20 17:12
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        System.out.println("Server received : " + in.toString(CharsetUtil.UTF_8));
        channelHandlerContext.write(in);
    }
}
