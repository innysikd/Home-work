package com.igoshev;

import java.util.Arrays;

public class Array {

    int[] source;

    public Array() {  // empty constructor
        this.source = new int[0];
    }

    public Array(int[] source) { // constructor with an array as an argument
        this.source = ArrayUtils.copyArray(source);
    }

    // array[index] = value
    public void set(int index, int value) {
        for (int i = 0; i < this.source.length; i++) {
            this.source[index] = value;
        }
    }

    //int a = array [index]
    //int a = ourArray.get(index)

    public int get(int index) {
        return this.source[index];
    }

    // this = object, to with was the method called
    public int size() {
        return this.source.length;
    }

    /**
     * add a value to the end of the current object
     *
     * @param value element to add
     */

    public void append(int value) {
        this.source = ArrayUtils.append(this.source, value);
    }

    public void insert(int index, int number) {
        this.source = ArrayUtils.insert(this.source, index, number);
    }

    /*
    array = {1,2,3,4}
    array.removeById(2) --> {1,2,4}]
    boolean wasRemoved = array.remove(5) --> false (array wasn't changed)
    boolean wasRemoved = array.remove(2) --> true (array length is -1) {1,4}
     */

    public void removeById (int index) {
        this.source = ArrayUtils.removeById(this.source, index);
    }

//    public boolean remove (int element){
//        int middle = 0;
//        ArrayUtils.binarySearch(this.source, element);
//        for (int i = 0; i < this.source.length; i++) {
//            middle = this.source[i];
//        }
//        ArrayUtils.removeById(this.source, middle);
//        return true;
//    }

    public String toString(){
        return Arrays.toString(this.source);
    }




}
