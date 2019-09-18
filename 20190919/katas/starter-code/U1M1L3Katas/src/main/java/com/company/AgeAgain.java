package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int age=Integer.parseInt(scanner.nextLine());
        if (age<14){
            System.out.println("What grade are you in?");
            String grade=scanner.nextLine();
            System.out.println("Wow! "+grade+" grade - that sounds exciting!");
        }else if (14<=age&&age<=18){
            System.out.println("Are you planning to go to college.");
            String ans=scanner.nextLine();
            if (ans.equals("yes")){
                System.out.println("Which college?");
                String college=scanner.nextLine();
                System.out.println(college+" is a great school!");
            }
            if (ans.equals("no")){
                System.out.println("What do you want to do after high school?");
                String plan=scanner.nextLine();
                System.out.println("Wow, " +plan+" sounds like a plan!");
            }
        }else if(age>18){
            System.out.println("What is your job?");
            String job=scanner.nextLine();
            System.out.println(job+" sounds like a great job!");
        }
    }
}
