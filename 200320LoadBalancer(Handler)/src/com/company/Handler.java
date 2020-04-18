package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class Handler implements Runnable{

    private int port;
    private String handlerHost;

    public Handler(String handlerHost, int port) {
        this.handlerHost = handlerHost;
        this.port = port;
    }

    @Override
    public void run() {

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

            (new Thread (new Reporter(executor, handlerHost, port))).start();

            while (true){
                Socket socket = serverSocket.accept();
                TextProcessor textProcessor = new TextProcessor(socket);
                executor.execute(textProcessor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
