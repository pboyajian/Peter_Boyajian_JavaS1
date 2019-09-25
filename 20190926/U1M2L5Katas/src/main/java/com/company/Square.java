package com.company;

import com.company.interfaces.Shape;

public class Square implements Shape {
    double length;

//    public Square(int length) {
//        this.length = length;
//    }


    @Override
    public double perimeter() {
        return length*4;
    }

    @Override
    public double area() {
        return length*length;
    }
}
