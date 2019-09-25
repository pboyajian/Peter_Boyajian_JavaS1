package com.company;

import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("You slide up to Speedy Petey's card table and plop down your cash.");
        System.out.println("He glances at you out of the corner of his eye and starts shuffling.");
        System.out.println("He lays down three cards.");
        System.out.println();
        System.out.println("Which one is the Ace?");
        int pos=random.nextInt(3)+1;
        System.out.println();
        System.out.println("     ##   ##   ##");
        System.out.println("     ##   ##   ##");
        System.out.println("     1    2    3");
        System.out.println();
        System.out.print("> ");
        int userInput=Integer.parseInt(scanner.nextLine());
        System.out.println();
        if (userInput==pos) {
            System.out.println("You nailed it! Speedy Petey reluctantly hands over your winnings, scowling.");
        }else{
            System.out.println("Ha! Speedy Petey wins again! The ace was card number "+pos+".");
        }
        String str="     ";
        for (int i = 0; i < 3; i++) {
            if (pos==i+1){str+="AA";}
         else {str+="##";}
         str+="   ";
    }
        System.out.println(str);
        System.out.println(str);
        System.out.println("     1    2    3");

    }
}
