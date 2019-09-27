package com.company;

import java.util.Scanner;

public class BabyNim {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=3,b=3,c=3;
        String str="";
        int amnt=0;
        while(a>0||b>0||c>0){
            System.out.printf("A: %d   B:  %d   C:  %d  \n",a,b,c);
            System.out.print("Choose a pile: ");
            str=scanner.nextLine();
            System.out.println();
            System.out.print("How many to remove from Pile "+str.toUpperCase()+": ");
            amnt=Integer.parseInt(scanner.nextLine());
            switch (str){
                case "A":
                case "a":
                    a-=amnt;
                    break;
                case "B":
                case"b":
                    b-=amnt;
                    break;
                case "C":
                case "c":
                    c-=amnt;
                    break;
            }
        }
        System.out.printf("A: %d   B:  %d   C:  %d  \n",a,b,c);
        System.out.println();
        System.out.println("All piles are empty. Good job!");
    }
}
