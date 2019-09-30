package com.company;

public class ConverterApplication {
    public static void main(String[] args) {
        ConverterIf converterIf=new ConverterIf();
        ConverterSwitch converterSwitch=new ConverterSwitch();
        System.out.println("Month Tests:");
        System.out.printf("%-20s %-5s %-15s %n","Class","input","output");
        for (int i = 1; i <= 13; i++) {
            System.out.printf("%-20s %-5d %-15s %n","ConverterIf",i,converterIf.convertMonth(i));
            System.out.printf("%-20s %-5d %-15s %n","ConverterSwitch",i,converterSwitch.convertMonth(i));
        }
        System.out.println("Day Tests:");
        System.out.printf("%-20s %-5s %-15s %n","Class","input","output");
        for (int i = 1; i <= 8; i++) {
            System.out.printf("%-20s %-5d %-15s %n","ConverterIf",i,converterIf.convertDay(i));
            System.out.printf("%-20s %-5d %-15s %n","ConverterSwitch",i,converterSwitch.convertDay(i));
        }
    }
}
