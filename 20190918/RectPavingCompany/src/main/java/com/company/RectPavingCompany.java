package com.company;

import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        double bulkCost=12.5;
//        double frameCost=8.25;
        System.out.println("Width of Driveway (ft):");
        double width=Double.parseDouble(scanner.nextLine());
        System.out.println("Length of Driveway (ft):");
        double length=Double.parseDouble(scanner.nextLine());
        System.out.println("Cost of bulk cement:");
        double bulkCost=Double.parseDouble(scanner.nextLine());
        System.out.println("Cost of framing:");
        double frameCost=Double.parseDouble(scanner.nextLine());
        double area=width*length;
        double perimeter=2*(width+length);
        System.out.println("Area= "+area);
        System.out.println("Perimeter= "+perimeter);
        System.out.format("Bulk cement cost= %.2f",bulkCost*area);
        System.out.println();
        System.out.format("Frame cement cost= %.2f",frameCost*perimeter);

    }
}
