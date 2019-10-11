package com.trilogyed.RESTCalculator.model;

import java.util.Objects;

public class Calculator {
    private  double op1;
    private  double op2;

    public Calculator(double op1, double op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    public  double sum(){
        return op1+op2;
    }
    public  double mult(){
        return op1*op2;
    }
    public  double subtract(){
        return op1-op2;
    }
    public  double divide(){
        return op1/op2;
    }

    public double getOp1() {
        return op1;
    }

    public void setOp1(double op1) {
        this.op1 = op1;
    }

    public double getOp2() {
        return op2;
    }

    public void setOp2(double op2) {
        this.op2 = op2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Double.compare(that.op1, op1) == 0 &&
                Double.compare(that.op2, op2) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(op1, op2);
    }
}
