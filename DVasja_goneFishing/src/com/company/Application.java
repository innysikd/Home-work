package com.company;

public class Application {

    public static void main(String[] args) {

        System.out.println(isVasjaGoesFishing(2, 30));

        String result = isVasjaGoesfishing1(4, 30);

        System.out.println(result);


    }

    public static boolean isVasjaGoesFishing (int day, int temp) {
        if (day == 4 && temp >= 19 && temp <= 23){
            return true;
        }
        return false;
    }

    public static String isVasjaGoesfishing1 (int day, int temp) {
        if (day == 4 && temp >= 19 && temp <= 23) {
            return "Vasja is going fishing";
        } else {
            String s = "Vasja is not going fishing. ";
            if (day < 4) {
                int daysLeft1 = 4 - day;
                return s + "There are " + daysLeft1 + " days left";
            } else if (day > 4) {
                int daysLeft2 = day - 4;
                return s + "There are " + daysLeft2 + " days left";
            } else if (temp < 19) {
                return s + "It's too cold";
            } else if (temp > 23) {
                return s + "It's too hot";
            }
        }
        return "";

    }


}
