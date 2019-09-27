package com.company;

import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=3,b=4,c=5;
        String str="";
        int amnt=0;
        System.out.print("Player 1, enter your name: ");
        String player1=scanner.nextLine();
        System.out.print("Player 2, enter your name: ");
        String player2=scanner.nextLine();
        String activePlayer="";
        boolean isEven=false;
        while(a>0||b>0||c>0){
            isEven=!isEven;
            if (isEven){activePlayer=player1;}
            else{activePlayer=player2;}
            System.out.printf("A: %d   B:  %d   C:  %d  \n",a,b,c);
            System.out.print(activePlayer+", choose a pile: ");
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
        if (activePlayer.equals((player1))){activePlayer=player2;}
        else{activePlayer=player1;}
        System.out.printf("A: %d   B:  %d   C:  %d  \n",a,b,c);
        System.out.println("There are no tiles left, so "+activePlayer+" is the winner!");
        System.out.println();
        System.out.println("All piles are empty. Good job!");
    }
}
