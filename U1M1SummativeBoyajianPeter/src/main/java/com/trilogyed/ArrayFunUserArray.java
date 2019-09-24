package com.trilogyed;

import java.util.Scanner;

public class ArrayFunUserArray {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] userArr=new int[5];
        int userInput;
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter an int.");
            userInput=Integer.parseInt(scanner.nextLine());
            userArr[i]=userInput;
        }
        for (int el:userArr
             ) {
            System.out.println(el);
        }
    }
}
