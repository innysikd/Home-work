package com.company;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        RandomRule minMaxRule = new MinMaxRule(-3, 7);
        RandomGenerator minMaxGenerator = new RandomGenerator(minMaxRule);

        minMaxGenerator.nextInts(10);

        RandomRule evenRule = new EvenRule();
        RandomGenerator evenGenerator = new RandomGenerator(evenRule);

        System.out.println();

        evenGenerator.nextInts(10);

    }
}

