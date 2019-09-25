package com.company;

import java.util.Random;

public class ShorterDoubleDice {
    public static void main(String[] args) {

        Random random = new Random();
        System.out.println("Here comes the dice!".toUpperCase());
        int roll1;
        int roll2;
        do{
            roll1=random.nextInt(6)+1;
            roll2=random.nextInt(6)+1;
            System.out.println();
            System.out.println("Roll #1: "+roll1);
            System.out.println("Roll #2: "+roll2);
            System.out.println("The total is "+(roll1+roll2)+"!");
        }while(roll1!=roll2);

    }
}
