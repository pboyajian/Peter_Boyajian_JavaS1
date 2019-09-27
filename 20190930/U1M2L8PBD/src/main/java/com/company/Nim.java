package com.company;

import java.util.Scanner;

public class Nim {
    Scanner scanner=new Scanner(System.in);

    public String getPile(String activePlayer,int a,int b,int c){
       String str;
       int pile=0;
        System.out.print(activePlayer+", choose a pile: ");
        str=scanner.nextLine().toUpperCase();
        switch (str){
            case "A":
                pile=a;
                break;
            case "B":
                pile=b;
                break;
            case "C":
                pile=c;
                break;
            default:
                System.out.println("You did not enter a valid pile.");
                str=getPile(activePlayer,a,b,c);
        }
        if (pile<=0){
            System.out.println("Nice try, that pile is empty.");
            str=getPile(activePlayer,a,b,c);
        }
        return str;

    }

    public int getAmnt(String str, int a,int b,int c){

        System.out.print("How many to remove from Pile "+str.toUpperCase()+": ");
        int amnt=Integer.parseInt(scanner.nextLine());
        if (amnt<=0){
            System.out.println("You must take at least 1 piece.");
            amnt=getAmnt(str,a,b,c);
        }
        switch (str.toUpperCase()){
            case "A":
                if (a<amnt){
                    System.out.println("Pile A does not have that many!");
                    amnt=getAmnt(str,a,b,c);
                };
                break;
            case "B":
                if (b<amnt){
                    System.out.println("Pile B does not have that many!");
                    amnt=getAmnt(str,a,b,c);}
                break;
            case "C":
                if (c<amnt){
                    System.out.println("Pile C does not have that many!");
                    amnt=getAmnt(str,a,b,c);}
                break;
        }
        return amnt;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Nim nim=new Nim();
        int a=3,b=4,c=5;
        String str="";
        int amnt=0;
        System.out.print("Player 1, enter your name: ");
        String player1=scanner.nextLine();
        System.out.print("Player 2, enter your name: ");
        String player2=scanner.nextLine();
        String activePlayer="";
        boolean isEven=false,lost=false;
        while(a+b+c>1){

            isEven=!isEven;
            if (isEven){activePlayer=player1;}
            else{activePlayer=player2;}

            System.out.printf("A: %d   B:  %d   C:  %d  \n",a,b,c);
            System.out.println();

            str=nim.getPile(activePlayer,a,b,c);
            amnt=nim.getAmnt(str,a,b,c);
            switch (str){
                case "A":
                    a-=amnt;
                    break;
                case "B":
                    b-=amnt;
                    break;
                case "C":
                    c-=amnt;
                    break;
            }
            if (a+b+c<1){lost=true;}

        }

        System.out.printf("A: %d   B:  %d   C:  %d  \n",a,b,c);
        if(!lost){
        System.out.println("There is only one tile left, so "+activePlayer+" is the winner!");}else{
            System.out.println(activePlayer+" could have won, but took all of the remaining tiles and lost.");}
    }
}
