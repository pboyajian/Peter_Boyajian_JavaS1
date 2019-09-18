package com.company;

import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a cap");
        int cap=Integer.parseInt(scanner.nextLine());
        boolean isPrime;
        for (int i = 2; i <= cap; i++) {
            isPrime=true;
            for (int j = 2; j < Math.sqrt(i)+1; j++) {
                if (i%j==0&&i!=2){
                    isPrime=false;
                }
            }
            if (isPrime){
                System.out.println(i);
            }

        }
    }
}
