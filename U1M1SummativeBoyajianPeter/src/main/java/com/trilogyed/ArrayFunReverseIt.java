package com.trilogyed;

public class ArrayFunReverseIt {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int[] revArr=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            revArr[i]=arr[arr.length-i-1];
        }
        System.out.println("arr     revArr");
        System.out.println("---------------");
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]+"         "+revArr[i]);
        }
    }
}
