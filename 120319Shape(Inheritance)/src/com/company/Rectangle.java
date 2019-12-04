package com.company;

public class Rectangle extends Shape {

    int width;
    int height;

    public Rectangle(char symbol, int width, int height) {
        super(symbol);
        this.width = width;
        this.height = height;
    }

//    @Override
//    public void draw() {
//        Rectangle rectangle = new Rectangle(symbol, width, height);
//        for (int i = 0; i < height; i++) {
//            System.out.println();
//            for (int j = 0; j < width; j++) {
//                System.out.print(symbol + " ");
//            }
//        }
//    }

    @Override
    public void draw() {
        Rectangle rectangle = new Rectangle(symbol, width, height);
        if (width > 1 && height > 1){
            for (int i = 0; i < width; i++) {
                System.out.print(symbol + " ");
            }

            for (int i = 1; i < height - 1; i++) {
                System.out.println();
                for (int j = 0; j < 1; j++) {
                    System.out.print(symbol + " ");
                }
                for (int j = 1; j <width-1 ; j++) {
                    System.out.print("  ");
                }
                for (int j = width - 1; j < width; j++) {
                    System.out.print(symbol);
                }
            }
            System.out.println();

            for (int j = 0; j < width; j++) {
                System.out.print(symbol + " ");
            }

        }else{
            System.out.println("*");
        }


    }



}
