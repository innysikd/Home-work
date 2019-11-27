package com.igoshev;

public class ArrayUtils {

    public static int[] copyArray (int[] array){
        int[] newArray = new int[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array [i];
        }
        return newArray;
    }

    public static int[] sortArray (int[] array){
        int tmp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array [j-1]){
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
            }
        }
        return array;
    }

    public static int[] append (int[] array, int value){
        int size = array.length + 1;
        int[] newArray = new int[size];

        for (int i = 0; i < size-1; i++) {
            newArray[i] = array[i];
        }
        newArray[size-1] = value;

        return newArray;
    }

    public static int[] insert (int[] array, int index, int value){
        int size = array.length+1;
        int[] newArray = new int[size];
        for (int i = 0; i < size-1; i++) {
            newArray[i] = array[i];
        }

        for (int i = size-1; i > index; i--) {
            newArray[i] = newArray[i-1];
        }
        newArray[index] = value;

        return  newArray;
    }




}

 /*
    new Class (ArrayUtils):
    with static methods:
    1. copy array
    public static int[] copyArray (int[]Array)
    create a new array and copy the elements from another

    2*. sort array inside itself

    3*. binarySearch

    4. append: return a copy of an array with a new added element at the end
    public static int[] append (int[] array, int value)
    {1,2,3] + 4 = (1,2,3,4}

    5. insert an element in the middle of the array
    public static int[] insert (int[] array, int index, int value)
     */
