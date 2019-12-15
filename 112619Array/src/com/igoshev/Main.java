package com.igoshev;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] javaArray = new int[]{1,3,-8};

//        Array ourArray = new Array (new int[]{1,3,-8});
//        int a1 = javaArray[0]; //1
//        int a2 = ourArray.get(0); //1 -  we use here the method get to find the index [0]
//
//        ArrayUtils.selectionSort(javaArray);
//        System.out.println(Arrays.toString(javaArray));
//
        Array ourArray = new Array(javaArray);

        for (int i = 0; i < javaArray.length; i++) {
            System.out.println(ourArray.get(i));
        }

        System.out.println(ourArray.get(1));  // = 3

        System.out.println(ourArray.toString());

        ourArray.removeById(2);
        System.out.println(ourArray.toString());

        ourArray.remove(0);
        System.out.println(ourArray.toString());


    }
}
