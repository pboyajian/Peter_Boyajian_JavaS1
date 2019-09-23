package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class HiLoWithLimitedTries {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random rand = new Random();
        int n = rand.nextInt(100)+1;
        int guess=-1;
        int numGuesses=0;
        boolean guessed=false;
        String str="First guess";

        System.out.println("I'm thinking of a number between 1-100. You have 7 guesses.");
        while(guess!=n&&numGuesses<7) {
            System.out.print(str+": ");
            guess = Integer.parseInt(scanner.nextLine());
            numGuesses++;
            str="Guess # "+(numGuesses+1);
            if (guess == n) {
                System.out.println("You guessed it! What are the odds?!?");
                guessed=true;
            } else if (guess < n) {
                System.out.println("Too Low!");
            } else {
                System.out.println("Too High!");
            }
        }
        if (guessed==false){
            System.out.println("Sorry, you didn't guess it in 7 tries. You Lose.");
        }
    }
}
