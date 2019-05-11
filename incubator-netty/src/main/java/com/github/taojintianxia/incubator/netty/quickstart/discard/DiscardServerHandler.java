package com.github.taojintianxia.incubator.netty.quickstart.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * DiscardServerHandler extends ChannelInboundHandlerAdapter, which is an implementation of ChannelInboundHandler.
 * ChannelInboundHandler provides various event handler methods that you can override. For now,
 * it is just enough to extend ChannelInboundHandlerAdapter rather than to implement the handler interface by yourself.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /** We override the channelRead() event handler method here. This method is called with the received message,
     *  whenever new data is received from a client. In this example, the type of the received message is ByteBuf.
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        try {
            while (in.isReadable()) { // (1)
                System.out.print((char) in.readByte());
                System.out.flush();
            }
        } finally {
            ReferenceCountUtil.release(msg); // (2)
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
