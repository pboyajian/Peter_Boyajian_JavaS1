package com.trilogyed;

import java.util.Scanner;

public class SpaceBoxing {
    public static void main(String[] args) {
        double weight;
        double venus=.78,mars=.39,jupiter=2.65,saturn=1.17,uranus=1.05,neptune=1.23;
        double[] gravity={venus,mars,jupiter,saturn,uranus,neptune};
        Scanner scanner=new Scanner(System.in);
        System.out.print("Please enter your current earth weight: ");
        weight=Double.parseDouble(scanner.nextLine());
        System.out.println("I have information for the following planets:");
        System.out.print("  1. Venus  ");
        System.out.print("2. Mars   ");
        System.out.println("3. Jupiter");
        System.out.print("  4. Saturn ");
        System.out.print("5. Uranus ");
        System.out.println("6. Neptune");

        System.out.println("");
        System.out.print("Which planet are you visiting? ");
        int userInput=Integer.parseInt(scanner.nextLine());
        System.out.println("");
        System.out.println("Your weight would be "+gravity[userInput-1]*weight+" pounds on that planet.");
    }
}
