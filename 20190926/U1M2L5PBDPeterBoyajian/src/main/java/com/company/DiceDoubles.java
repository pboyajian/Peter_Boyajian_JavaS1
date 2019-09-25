package com.company;

import java.util.Random;

public class DiceDoubles {
    public static void main(String[] args) {

        Random random = new Random();
        System.out.println("Here comes the dice!".toUpperCase());
        int roll1=0,roll2=-1;
        while(roll1!=roll2){
            roll1=random.nextInt(6)+1;
            roll2=random.nextInt(6)+1;
            System.out.println();
            System.out.println("Roll #1: "+roll1);
            System.out.println("Roll #2: "+roll2);
            System.out.println("The total is "+(roll1+roll2)+"!");
        }

    }
}
