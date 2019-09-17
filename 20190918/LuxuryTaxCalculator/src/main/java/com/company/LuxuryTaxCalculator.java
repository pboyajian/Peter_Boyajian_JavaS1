package com.company;

import java.util.Scanner;

public class LuxuryTaxCalculator {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Player 1 Salary (without $ or ,))");
        int salary1=Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Player 2 Salary (without $ or ,))");
        int salary2=Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Player 3 Salary (without $ or ,))");
        int salary3=Integer.parseInt(scanner.nextLine());
        int total=salary1+salary2+salary3;
        System.out.println("total = " + total);
        int max=40000000;
        if (total>max){
            System.out.println("Luxury Tax= "+0.18*(total-max));
        }
        else{
            System.out.println("Luxury Tax=0");
        }
    }
}
