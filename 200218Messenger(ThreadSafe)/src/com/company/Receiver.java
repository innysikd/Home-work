package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Receiver extends Thread {

    Messenger messenger;
    String outputFile;
    List<String> list = new ArrayList<>();

    public Receiver(Messenger messenger, String outputFile, List<String> list) {
        this.messenger = messenger;
        this.outputFile = outputFile;
        this.list = list;
    }

    @Override
    public void run() {

        while ((true)){
            try {
                String message = messenger.removeMessage();
                PrintWriter pw = new PrintWriter(outputFile);
                list.add(message);
                pw.println(list);

                pw.flush();
                pw.close();



                // String message = messenger.removeMessage();
                // System.out.println(message + " " + getName());

            } catch (InterruptedException | IOException e) {
                return;
            }
        }
    }
}
