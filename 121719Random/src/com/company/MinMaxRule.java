package com.company;

import java.util.Random;

public class MinMaxRule implements RandomRule {

    int min;
    int max;

    public MinMaxRule(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int nextInt() {
        Random randomNumber = new Random();

        int nextInt = min + randomNumber.nextInt(max - min);

        return nextInt;
    }
}