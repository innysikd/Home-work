package com.company;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        Line line1 = new Line('*', 8);
        line1.draw();

        System.out.println();

        Rectangle rec1 = new Rectangle('*',10,5);
        rec1.draw();

        System.out.println();

        Shape[] shapes = new Shape[]{line1, rec1};

        Shape picture = new Picture('*', shapes);
        picture.draw();


    }
}
