package com.company;

import java.util.Scanner;

public class AddFive {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter 5 numbers (press enter after each one)");
        double firstNumber= Double.parseDouble(scanner.nextLine());
        double secondNumber= Double.parseDouble(scanner.nextLine());
        double thirdNumber= Double.parseDouble(scanner.nextLine());
        double fourthNumber= Double.parseDouble(scanner.nextLine());
        double fifthNumber= Double.parseDouble(scanner.nextLine());
        double avg=(firstNumber+secondNumber+thirdNumber+fourthNumber+fifthNumber);
        System.out.println("The sum is "+String.format( "%.0f",avg));
    }
}
