package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter 1 number");
        double firstNumber= Double.parseDouble(scanner.nextLine());
        System.out.println("The answer is "+String.format( "%.0f",(5+firstNumber)*2));


    }
}
