package com.github.taojintianxia.incubator.netty.inaction.chapter2.echo;

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

    }
}
