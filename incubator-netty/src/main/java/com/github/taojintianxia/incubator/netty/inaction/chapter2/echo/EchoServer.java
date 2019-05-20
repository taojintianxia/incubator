package com.github.taojintianxia.incubator.netty.inaction.chapter2.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author Nianjun Sun
 * @date 2019-05-20 17:55
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String... args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage : " + EchoServer.class.getSimpleName() + " <port> ");
            int port = Integer.parseInt(args[0]);
            new EchoServer(port).start();
        }
    }

    public void start() throws Exception {
        final EchoServerHandler echoServerHandler = new EchoServerHandler();
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(eventLoopGroup).channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port)).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(echoServerHandler);
                }
            });
            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully().sync();
        }
    }
}
