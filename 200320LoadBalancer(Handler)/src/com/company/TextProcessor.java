package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TextProcessor implements Runnable {

    private Socket socket;

    public TextProcessor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try{
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream socketOutput = new PrintStream(socket.getOutputStream());

            String text = socketInput.readLine();
            text = text.toUpperCase();
            socketOutput.println(text);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
