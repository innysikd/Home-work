package com.igoshev;

public class Main {

    public static void main(String[] args) {

        int[] javaArray = new int[]{1,3,-8};
        Array ourArray = new Array (new int[]{1,3,-8});

        int a1 = javaArray[0]; //1
        int a2 = ourArray.get(0); //1 -  we use here the method get to find the index [0]


    }
}
