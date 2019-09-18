package com.company;

import java.util.Scanner;

public class CountByTwo {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Input a number");
        int max=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <= max ; i+=2) {
            System.out.println(i);
        }
    }
}
