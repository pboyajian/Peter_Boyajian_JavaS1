package com.company;

import java.util.Scanner;

public class AddingValuesInALoop {
    public static void main(String[] args) {
        int total=0;
        Scanner scanner =new Scanner(System.in);
        System.out.println("I will add up the numbers you give me.");
        int userInput=-1;
        while(userInput!=0){
            System.out.print("Number: ");
            userInput=Integer.parseInt(scanner.nextLine());
            total+=userInput;
            if(userInput!=0) {
                System.out.println("The total so far is "+total);
        }
        }
        System.out.println();
        System.out.println("The total is "+total);
    }
}
