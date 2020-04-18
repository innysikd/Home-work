package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class Handler implements Runnable{

    private int port;

    public Handler(int port) {
        this.port = port;
    }

    @Override
    public void run() {

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

            (new Thread (new Reporter(executor, port))).start();

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
