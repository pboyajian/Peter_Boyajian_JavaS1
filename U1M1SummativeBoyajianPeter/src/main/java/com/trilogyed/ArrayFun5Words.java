package com.trilogyed;

import java.util.Scanner;

public class ArrayFun5Words {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] userArr=new String[5];
        String userInput;
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter a String.");
            userInput=scanner.nextLine();
            userArr[i]=userInput;
        }
        for (String el:userArr
        ) {
            System.out.println(el);
        }
    }
}
