package com.company;

public class Censor {

    String[] badWords;

    public Censor(String[] badWords) {
        this.badWords = badWords;
    }

    boolean isLegal (String text){
        String text1 = text.toLowerCase();
        for (int j = 0; j < badWords.length; j++) {
            if(text1.contains(badWords[j]))
                return false;
        }

        return true;
    }
}
