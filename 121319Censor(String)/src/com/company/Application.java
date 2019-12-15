package com.company;

public class Application {

    public static void main(String[] args) {

        String[] illegalWords = {"test", "rest", "best"};
        Censor vasya = new Censor(illegalWords);

        String[] illegalWords2 = {"cast", "trust"};
        Censor petya = new Censor(illegalWords2);

        String text1 = new String("very crazy feast");
        String text2 = new String("test my very best trust");

                boolean isLegal = vasya.isLegal(text1);
                boolean isLegal1 = petya.isLegal(text2);

        System.out.println(isLegal);
        System.out.println(isLegal1);

    }
}
