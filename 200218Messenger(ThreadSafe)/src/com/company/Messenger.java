package com.company;

public class Messenger {

    private final Object mu = new Object();
    private volatile String message;  // volatile variable is used directly and doesn't go inside cash at first

    public void addMessage(String message){
        synchronized (mu){
            this.message = message;
            mu.notify();
        }
    }

    public String removeMessage() throws InterruptedException {
        synchronized (mu){
            while (message == null)
                mu.wait(); // mutex mu is now free. block of the code with mu is now free to use mu

            String res = message;
            message = null;

            return res;
        }
    }
}
