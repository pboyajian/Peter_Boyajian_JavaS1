package com.company;

public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            if (i%15==0){
                System.out.println("FIZZBUZZ");
            }else if(i%5==0){
                System.out.println("BUZZ");
            }else if (i%3==0){
                System.out.println("FIZZ");
            }else{
                System.out.println(i);
            }

        }
    }
}
