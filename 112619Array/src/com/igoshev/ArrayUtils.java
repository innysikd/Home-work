package com.igoshev;

public class ArrayUtils {

    public static int[] copyArray (int[] array){
        int[] result = new int [array.length];
        for (int i = 0; i < result.length ; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static int[] append (int[] array, int number){
        int oldLength = array.length;
        int[] result = new int[oldLength + 1];
        for (int i = 0; i < result.length ; i++) {
            result[i] = array[i];
        }
        result[oldLength] = number;
        return result;

    }

    public static int[] appendWithInsert (int[] array, int number){
        int[]result = insert(array, array.length, number);
        return result;
    }

    public static int[] insert(int[] array, int index, int number){
        int[] result = new int[array.length + 1];
        for (int i = 0; i < index; i++) {
            result[i] = array[i];
        }
        result[index] = number;
        for (int i = index + 1; i < result.length; i++) {
            result[i] = array[i-1];
        }
        return result;
    }

    public static int binarySearch (int[] array, int number){
        int left = 0;
        int right = array.length - 1;

        while (left <= right){
            int middle = left + right / 2;
            if (array[middle] < number){
                left = middle + 1;
            }else if (array[middle] > number){
                right = middle -1;
            }else{
                return middle;
            }
        }
        return -(left + 1);
        // if dont find the number in the array, we return a hypothetical index [-(index +1)], where it could be in the array
    }

    public static void selectionSort (int[] array){
        for (int i = 0; i < array.length; i++) { // this loop stores the sorted part of the array

            int minId = i;

            for (int j = i; j < array.length; j++) {  // this loop looks inside the unsorted array for the minimum number
                if (array[minId] > array[j]){
                    minId = j;
                }
            }

            int temp = array[i];        // we insert the numbers one by one into a sorted part
            array[i] = array[minId];
            array[minId] = temp;
        }
    }

    public static int[] removeById (int[] array, int index) {
        int size = array.length - 1;
        int[] result = new int[size];
        if (index == array.length-1){
            for (int i = 0; i < size; i++) {
                result[i] = array[i];
            }
            return result;
        }else{
            result [index] = array[index + 1];
            for (int i = 0; i <index; i++) {
                result[i] = array[i];
            }

            for (int i = index + 1; i <array.length; i++) {
                result[i - 1] = array[i];
            }
        }
        return result;
    }






}
