package com.company;

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Amount:");
        double amount=Double.parseDouble(scanner.nextLine());
        System.out.println("Term:");
        double term=Double.parseDouble(scanner.nextLine());
        System.out.println("Annual Interest Rate:");
        double rate=Double.parseDouble(scanner.nextLine())/1200;
        double payment=(amount* rate*Math.pow(1+rate,term))/
                (Math.pow(1+rate,term)-1);
        System.out.println("payment = " + payment);
    }
}
