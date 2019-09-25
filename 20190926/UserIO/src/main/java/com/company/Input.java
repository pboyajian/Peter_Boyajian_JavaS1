package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class Input implements UserIO {
    Scanner scanner=new Scanner(System.in);
    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        return Long.parseLong(scanner.nextLine());
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        return Double.parseDouble(scanner.nextLine());
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        return Float.parseFloat(scanner.nextLine());
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
