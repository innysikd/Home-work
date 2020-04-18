package com.company;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.ThreadPoolExecutor;

public class Reporter implements Runnable {

    private ThreadPoolExecutor executor;
    private static final String SERVER = "localhost";
    private static final int SERVER_PORT = 3500;
    private static final int SLEEP_INTERVAL = 1000;
    private String handlerHost;
    private int handlerPort;

    public Reporter(ThreadPoolExecutor executor, String handlerHost, int handlerPort) throws UnknownHostException {
        this.executor = executor;
        this.handlerHost = handlerHost;
        this.handlerPort = handlerPort;
    }

    @Override
    public void run() {

        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            InetAddress ip = InetAddress.getByName(SERVER);

            while (true){
                String info = handlerHost + ":" + (Integer.valueOf(handlerPort)).toString() + ":" + (Integer.valueOf(executor.getActiveCount()).toString());

                byte[] dataOut = info.getBytes();

                DatagramPacket packetOut = new DatagramPacket(
                        dataOut,
                        dataOut.length,
                        ip,
                        SERVER_PORT);

                datagramSocket.send(packetOut);

                System.out.println(info);

                Thread.sleep(SLEEP_INTERVAL);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
