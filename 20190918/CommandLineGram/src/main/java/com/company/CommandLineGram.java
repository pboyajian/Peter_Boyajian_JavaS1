package com.company;

import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("First Name:");
        String fNam=scanner.nextLine();
        System.out.println("Last Name:");
        String lNam=scanner.nextLine();
        System.out.println("Email:");
        String email=scanner.nextLine();
        System.out.println("Twitter Handle:");
        String twitterHandle=scanner.nextLine();
        System.out.println("Age:");
        String age=scanner.nextLine();
        System.out.println("Country:");
        String country=scanner.nextLine();
        System.out.println("Profession:");
        String profession=scanner.nextLine();
        System.out.println("Favorite operating system:");
        String favOpSys=scanner.nextLine();
        System.out.println("Favorite programming language:");
        String favProgLang=scanner.nextLine();
        System.out.println("Favorite computer scientist:");
        String favCompSci=scanner.nextLine();
        System.out.println("Favorite keyboard shortcut:");
        String favKeyShort=scanner.nextLine();
        System.out.println("Have you ever built your own computer?");
        String hasBuiltComputer=scanner.nextLine();
        System.out.println("If you could be any superhero, who would it be?");
        String superhero=scanner.nextLine();

        System.out.println("fNam = " + fNam);
        System.out.println("Last Name = " + lNam);
        System.out.println("email = " + email);
        System.out.println("twitterHandle = " + twitterHandle);
        System.out.println("age = " + age);
        System.out.println("country = " + country);
        System.out.println("profession = " + profession);
        System.out.println("favOpSys = " + favOpSys);
        System.out.println("favProgLang = " + favProgLang);
        System.out.println("favCompSci = " + favCompSci);
        System.out.println("favKeyShort = " + favKeyShort);
        System.out.println("hasBuiltComputer = " + hasBuiltComputer);
        System.out.println("superhero = " + superhero);
    }
}
