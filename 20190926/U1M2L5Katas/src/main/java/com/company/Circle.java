package com.company;

import com.company.interfaces.Shape;

public class Circle implements Shape {
    double radius;
//
//    public Circle(double radius) {
//        this.radius = radius;
//    }

    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }
}
