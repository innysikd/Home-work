package com.company;

public class Picture extends Shape {

    Shape[] shapes;

    public Picture(char symbol, Shape[] shapes) {
        super(symbol);
        this.shapes = shapes;
    }

    @Override
    public void draw() {
        int size = shapes.length;
        for (int i = 0; i < size ; i++) {
            shapes[i].draw();
            System.out.println();
        }
    }
}
