package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class KeepGuessing {
    public static void main(String[] args) {
        Random rand=new Random();
        Scanner scanner=new Scanner(System.in);
        int num=rand.nextInt(10)+1;
        int userInput=-1;
        System.out.println("I'm thinking of a number from 1 to 10.");
        while (userInput!=num) {
            System.out.print("Your guess: ");
            userInput = Integer.parseInt(scanner.nextLine());
            if (userInput == num) {
                System.out.println("That's right! You're a good guesser.");
            } else {
                System.out.println("That is incorrect. Guess again.");
            }
        }
    }
}
