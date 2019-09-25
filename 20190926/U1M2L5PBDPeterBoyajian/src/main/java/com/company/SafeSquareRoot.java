package com.company;

import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("square root!".toUpperCase());
        System.out.print("Enter a number: ");
        int userInput=Integer.parseInt(scanner.nextLine());;
        while(userInput<0){
            if (userInput<0){System.out.println("Enter a POSITIVE integer.");}
            System.out.print("Try again: ");
            userInput=Integer.parseInt(scanner.nextLine());
        }
        System.out.println("The square root of "+userInput+" is "+Math.sqrt(userInput));
    }
}
