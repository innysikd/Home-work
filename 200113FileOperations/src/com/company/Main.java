package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

//        List<Integer> ints = Arrays.asList(1, 67, -238, 13);
//
        FileOperations fo = new FileOperations();
//
//        fo.intsToFile(ints, "ints.txt");

        fo.fileToList("ints.txt");



    }

}
