package com.company;

public class App {

public static int subtract(int a, int b){
    return a-b;
}
public static int subtractOrZero(int a, int b){
    int val=a-b;
    if (val<0){
        return 0;
    }else{
        return val;
    }
}
public static int max(int a, int b, int c){
    return Math.max(Math.max(a,b),c);
}
public static int min(int a, int b, int c){
        return Math.min(Math.min(a,b),c);
    }
public static boolean isLarger(int first, int second){
    return first>second;
}
}
