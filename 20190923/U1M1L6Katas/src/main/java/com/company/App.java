package com.company;

public class App {

    public static int total(int[] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum;
    }

    public static int totalOdd(int[] arr){
        int sum=0;
        for (int i = 1; i < arr.length; i+=2) {
            sum+=arr[i];
        }
        return sum;
    }

    public static int totalEven(int[] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i+=2) {
            sum+=arr[i];
        }
        return sum;
    }

    public static int secondLargestNumber(int[] arr){
        int max=arr[0];
        int maxIx=0;
        for (int i =1; i < arr.length; i++) {
            if (arr[i]>=max){
                max=arr[i];
                maxIx=i;
            }
        }
        int maxTwo=Math.min(arr[0],arr[1]);
        for (int i =0; i < arr.length; i++) {
            if (arr[i]>=maxTwo&&i!=maxIx){
                maxTwo=arr[i];
            }
        }
        return maxTwo;
    }

    public static String[] swapFirstAndLast(String[] arr){
        String first=arr[0],last=arr[arr.length-1];
        String[] returnArr= new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            returnArr[i]=arr[i];
        }
        returnArr[0]=last;
        returnArr[arr.length-1]=first;
        return returnArr;
    }

    public static int[] reverse(int[] arr){
        int[] revArr=new int[arr.length];
        for (int i = arr.length; i >0 ; i--) {
            revArr[arr.length-i]=arr[i-1];
        }
        return revArr;
    }

    public static String concatenateString(String[] arr){
        String str="";
        for (String el: arr
             ) {
            str+=el;
        }
        return str;
    }

    public static int[] everyThird(int[] arr){
        int[] newArr=new int[arr.length/3];
        if (arr.length<3){
            return null;
        }
        for (int i = 2; i < arr.length; i+=3) {
            newArr[(i+1)/3-1]=arr[i];
        }
        return  newArr;
    }

    public static int[] lessThanFive(int[] arr){
        int num=0;
        for (int i:arr
             ) {
            if (i<5){
                num++;
            }
        }
        if (num==0){return null;}
        String str="";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<5){
                str+=arr[i]+"_";
            }
        }
        String[] strArr=str.split("_");
        int[] intArr=new int[num];
        for (int i = 0; i < num; i++) {
            intArr[i]=Integer.parseInt(strArr[i]);
        }

        return intArr;
    }

    public static int[] moreThanFive(int[] arr){
        int num=0;
        for (int i:arr
        ) {
            if (i>=5){
                num++;
            }
        }
        if (num==0){return null;}
        String str="";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>=5){
                str+=arr[i]+"_";
            }
        }
        String[] strArr=str.split("_");
        int[] intArr=new int[num];
        for (int i = 0; i < num; i++) {
            intArr[i]=Integer.parseInt(strArr[i]);
        }

        return intArr;
    }


    public static int[][] splitAtFive(int[] arr){
        int[] ltFive=lessThanFive(arr);
        int[] gtFive=moreThanFive(arr);

        if(gtFive==null){
           int[] gtFive2={};
            int[][] retArr={ltFive,gtFive2};
            return retArr;
        }
        if(ltFive==null){
            int[] ltFive2={};
            int[][] retArr={ltFive2,gtFive};
            return retArr;
        }
        int[][] retArr={ltFive,gtFive};

        return retArr;
    }

    public static String[][] evensAndOdds(String[] arr){
        int len=arr.length;
        String[] evens=new String[len/2];
        String[] odds=new String[len/2];
        if (len%2==1){
             evens=new String[len/2+1];
        }
        for (int i = 0; i < len; i+=2) {
            evens[i/2]=arr[i];
        }
        int counter=-1;
        for (int i = 0; i <len; i+=1) {
            if (i%2==1){
                counter++;
                odds[counter]=arr[i];
            }
        }
        String[][] retArr={evens,odds};
        return retArr;
    }
}
