package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter 2 numbers (press enter after each number)");
        double firstNumber= Double.parseDouble(scanner.nextLine());
        double secondNumber= Double.parseDouble(scanner.nextLine());
        System.out.println("The difference is "+String.format( "%.0f",firstNumber-secondNumber));

    }
}
