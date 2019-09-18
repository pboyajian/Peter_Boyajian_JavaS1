package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int userInput=0;
        while(!(userInput==42)){
            System.out.println("Enter an integer between 1 and 100 ");
            userInput=Integer.parseInt(scanner.nextLine());
        }
        System.out.println("That's the number I was looking for!" +
                " 42 is definitely the answer!");
    }
}
