package com.trilogyed;

public class SomeMath {
    public static int total5(int a,int b,int c,int d,int e){
        return a+b+c+d+e;
    }
    public static double average5(int a,int b,int c,int d,int e){
        return 1.0*(a+b+c+d+e)/5.0;
    }
    public static double largest5(double a,double b,double c,double d,double e){
        return Math.max(a,Math.max(b,Math.max(c,Math.max(d,e))));
    }

    public static void main(String[] args) {
        System.out.println(total5(1,2,3,4,5));
        System.out.println(average5(1,3,5,7,9));
        System.out.println(largest5(42.0,35.1,2.3,40.2,15.6));
    }
}
