package com.company;

import java.util.Scanner;

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String userInput="";
        while(!(userInput.equals("Java"))){
            System.out.println("Enter your favorite programming language");
            userInput=scanner.nextLine();
        }
        System.out.println("That's what I was looking for!" +
                " Java is definitely the answer!");

//        Scanner scanner= new Scanner(System.in);
//        int userInput=0;
//        while(!(15<userInput&&userInput<32)){
//            System.out.println("Enter an integer between 15 and 32 (not inclusive)");
//            userInput=Integer.parseInt(scanner.nextLine());
//        }
//        System.out.println(userInput);
    }
}
