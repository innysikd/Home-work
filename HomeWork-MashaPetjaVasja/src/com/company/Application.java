package com.company;

public class Application {

    private static double MASHA_VEL = 50; // credits per month
    private static double PETJA_VEL = 50 * 0.8;
    private static double LAZY_VASJA_VEL = 50 * 0.5;
    private static int BORDER_CREDITS = 1370;
    private static double MOTIVATED_VASJA_VEL = 50;

    public static void main(String[] args) {

        double credits = howManyMonth(2100);

        System.out.println(credits);

    }

    private static double howManyMonth (int totalCredits){
        double firstPack = BORDER_CREDITS  / (MASHA_VEL + PETJA_VEL + LAZY_VASJA_VEL);  // per month
        double secondPack = (totalCredits - BORDER_CREDITS) / (MASHA_VEL + PETJA_VEL + MOTIVATED_VASJA_VEL);
        double months = firstPack + secondPack;

        return months;
    }
}
