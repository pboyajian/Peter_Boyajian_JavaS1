package com.company;

import java.util.Random;

public class BabyBlackjack {
    public static void main(String[] args) {
        System.out.println("Baby Blackjack!");
        Random random=new Random();
        int u1=random.nextInt(10)+1;
        int d1=random.nextInt(10)+1;
        int u2=random.nextInt(10)+1;
        int d2=random.nextInt(10)+1;

        System.out.printf("\nYou drew %d and %d.\n",u1,u2);
        System.out.println("Your total is "+(u1+u2)+".");
        System.out.printf("\nThe dealer has %d and %d.\n",d1,d2);
        System.out.println("Dealer's total is "+(d1+d2)+".\n");

        if (u1+u2>d1+d2){
            System.out.println("YOU WIN!");
        }else if (u1+u2<d1+d2){
            System.out.println("YOU LOSE!");

        }else{
            System.out.println("It's a tie...");
        }
    }
}
