package com.company;

public class RandomGenerator {

    RandomRule rule;

    public RandomGenerator(RandomRule rule) {
        this.rule = rule;
    }

    public int[] nextInts(int n){

        int[] nextInts = new int[n];

        for (int i = 0; i < n; i++) {
            nextInts[i] = rule.nextInt();
            System.out.print(nextInts[i] + " ");
        }

        return nextInts;
    }




}
