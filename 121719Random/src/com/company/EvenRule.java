package com.company;

import java.util.Random;

public class EvenRule implements RandomRule {

    @Override
    public int nextInt() {
        Random randomNumber = new Random();

        int nextInt = 2 * randomNumber.nextInt();

        return nextInt;
    }
}
