package com.company;

import java.util.Random;
import java.util.Scanner;

public class HiLo {
    public static void main(String[] args) {
        System.out.println("Welcome to Hi-Low!");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your name.");
        String name=scanner.nextLine();
        System.out.println("OK, "+name+", here are the rules:");
        Random rand = new Random();
        int n = rand.nextInt(100)+1;
        int guess=-1;
        int counts=0;
       while(guess!=n) {
           System.out.println("Try to guess the number (integer between 1 and 100, inclusive)");
           guess = Integer.parseInt(scanner.nextLine());
           counts++;
           if (guess == n) {
               System.out.println("Congratulations, " + name + "! You win!");
               System.out.println("It took you "+counts+" guesses to find my number!");
           } else if (guess < n) {
               System.out.println("Too Low!");
           } else {
               System.out.println("Too High!");
           }
       }
    }
}
