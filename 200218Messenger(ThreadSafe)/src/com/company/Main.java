package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String OUTPUT_FILE = "outputFile.txt";
    private static final List<String> LIST = new ArrayList<>();

    public static void main(String[] args) {

        Messenger messenger = new Messenger();

        Thread sender = new Sender(messenger);

        Thread[] receivers = new Thread[5];

        for (int i = 0; i < receivers.length; i++) {
            receivers[i] = new Receiver(messenger, OUTPUT_FILE, LIST);
            receivers[i].setDaemon(true);
        }

        for (int i = 0; i < receivers.length; i++) {
            receivers[i].start();
        }

        sender.start();

    }
}
