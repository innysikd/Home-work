package com.company;

public class Line extends Shape {

    int length;

    public Line(char symbol, int length) {
        super(symbol);
        this.length = length;
    }

    @Override
    public void draw() {
        Line line = new Line(symbol, length);
        for (int i = 0; i < length; i++) {
            System.out.print(symbol);
        }
    }

}
