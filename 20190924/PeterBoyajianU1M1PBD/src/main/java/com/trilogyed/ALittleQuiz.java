package com.trilogyed;

import java.util.Scanner;

public class ALittleQuiz {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.print("Here comes a quiz... ");
        System.out.println();
        String userInput="";

        int numCorrect=0;
        System.out.println("Judge the validity of the following statements.");
        System.out.println("Enter T for true and F for false. You must enter a capital letter.");
        System.out.println();
        String[] questions={"5+5=10","5*20=101","14 is a prime number."};
        String[] answers={"T","F","F"};
        for (int i = 0; i < 3; i++) {
            System.out.println(questions[i]);
            userInput=scanner.nextLine();
            if (userInput.equals(answers[i])){
                numCorrect++;
                System.out.println();
                System.out.println("Correct!");
            }else{
            System.out.println();
            System.out.println("Incorrect!");}
        }
        System.out.println("Overall, you got "+numCorrect+" out of 3 correct.");
        System.out.println("Thanks for playing!");

    }
}
