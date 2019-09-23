package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class ANumberGuessingGame {
    public static void main(String[] args) {
        Random rand=new Random();
        Scanner scanner=new Scanner(System.in);
        int num=rand.nextInt(10)+1;
        System.out.println("I'm thinking of a number from 1 to 10.");
        System.out.print("Your guess: ");
        int userInput=Integer.parseInt(scanner.nextLine());
        System.out.println();
        if (userInput==num){
            System.out.println("That's right! My secret number was "+num+".");
        }else{
            System.out.println("Sorry, but I was really thinking of "+num+".");
        }
    }
}
