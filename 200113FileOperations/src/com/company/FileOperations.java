package com.company;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileOperations {

    public void intsToFile(List<Integer> ints, String filename) throws IOException {

        StringBuilder builder = new StringBuilder();

        for (Integer current : ints) {  // we use for each, so that we dont iterate with get(i). not good for a linked list
            builder.append(current);
            builder.append(" ");
        }

        bytesToFile(builder.toString().getBytes(), filename);
    }

    public void bytesToFile(byte[] bytes, String filename) throws IOException {

        FileOutputStream fos = new FileOutputStream(filename, true);

        // we dont want to handle the exception right now, so we just close it
        try {
            fos.write(bytes);
        } finally {
            fos.close();
        }
    }

    public void fileToList (String fileName) throws IOException {

        FileInputStream fis = new FileInputStream(fileName);

        int length = fis.available();  // we check for the length

        byte[] bytes = new byte[length];  // and translate it into bytes

        fis.read(bytes);

        fis.close();

        String res = new String(bytes);

        //We use the split method to convert our numbers string into an array of strings
        String[] convertedIntsArray = res.split(" ");

        //we convert each string in our new array to an integer and add it to our list:
        List<Integer> convertedIntsList = new ArrayList<Integer>();
        for (String number : convertedIntsArray) {
            convertedIntsList.add(Integer.parseInt(number));
        }

        System.out.println(Arrays.toString(convertedIntsList.toArray()));



    }



}
