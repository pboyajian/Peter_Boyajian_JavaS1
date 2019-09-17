package com.company;
import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter 3 numbers (press enter after each one)");

            double firstNumber= Double.parseDouble(scanner.nextLine());
            double secondNumber= Double.parseDouble(scanner.nextLine());
            double thirdNumber= Double.parseDouble(scanner.nextLine());
            double avg=(firstNumber+secondNumber+thirdNumber)/3;
            System.out.println("The average is "+String.format( "%.5f",avg));


        }
}
