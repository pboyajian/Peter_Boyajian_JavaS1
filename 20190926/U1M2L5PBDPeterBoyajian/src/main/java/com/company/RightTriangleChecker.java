package com.company;

import java.util.Scanner;

public class RightTriangleChecker {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter three integers:");
        int[] side=new int[3];
        int userInput=0;
        int counter=0;
        do{
            System.out.print("Side "+(counter+1)+": ");
            userInput=Integer.parseInt(scanner.nextLine());
            if (userInput>=side[Math.max(0,counter-1)]){
                side[counter]=userInput;
                counter++;}else{
                System.out.println(userInput+" is smaller than "+side[Math.max(0,counter-1)]+". Try again.");
            }
        }while(userInput<side[Math.max(0,counter-1)]||counter<3);
        System.out.println("Your three sides are "+side[0]+" "+side[1]+" "+side[2]);
        int a=side[0];
        int b=side[1];
        int c=side[2];
        if (a*a+b*b==c*c){
            System.out.println("These sides *do* make a right triangle. Yay!");
        }else{
            System.out.println("NO! These sides do not make a right triangle.");
        }


    }
}
