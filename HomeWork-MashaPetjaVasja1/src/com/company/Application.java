package com.company;

public class Application {

    private static int MASHA_CRED = 50; // credits per month
    private static int PETJA_CRED = 40;
    private static int VASJA_CRED = 50;
    private static int BORDER_MONTHS = 10;

    public static void main(String[] args) {

        int credits = totalCredits(18);
        System.out.println(credits);

    }

    public static int totalCredits (int months){
        int mashaVel = MASHA_CRED;
        int petjaVel = PETJA_CRED;
        int vasjaVel = VASJA_CRED;
        int firstPack = 0;
        int secondPack = 0;

        for (int i = 1; i<= BORDER_MONTHS; i++){

            firstPack = firstPack + mashaVel + petjaVel + vasjaVel;
            mashaVel++;
            if (i%2 == 0){
                petjaVel++;
            }
            vasjaVel--;
        }

        for (int i = 1; i<= (months-BORDER_MONTHS); i++){
            secondPack += mashaVel + petjaVel + vasjaVel;
            mashaVel++;
            if (i%2 == 0){
                petjaVel++;
            }
        }
        int total = firstPack + secondPack;

        return total;
    }
}
