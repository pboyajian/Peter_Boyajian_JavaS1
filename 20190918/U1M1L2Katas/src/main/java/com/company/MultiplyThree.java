package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter 5 numbers (press enter after each one)");
        double firstNumber= Double.parseDouble(scanner.nextLine());
        double secondNumber= Double.parseDouble(scanner.nextLine());
        double thirdNumber= Double.parseDouble(scanner.nextLine());
        double product=(firstNumber*secondNumber*thirdNumber);
        System.out.println("The product is "+String.format( "%.0f",product));

    }
}
