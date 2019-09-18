package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your age");
        int age=Integer.parseInt(scanner.nextLine());

        if (age>=18){
            System.out.println("you can vote");
            if (age>=21){
                System.out.println("you can drink alcohol");
                if (age>=35){
                    System.out.println("you can bepresident");
                    if (age>=55){
                        System.out.println("You can be in aarp");
                        if (age>=65){
                            System.out.println("You can retire");
                            if (age>79){
                                if (age>=80&&age<=89) {System.out.println("You're an octogenerian!");}
                                if (age>=100){
                                    System.out.println("You are over a century old");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
