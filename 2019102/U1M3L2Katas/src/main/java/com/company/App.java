package com.company;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static int total (List<Integer> numbers) {

        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }

        return sum;
    }

    public static int totalEven (List<Integer> numbers) {

        int sum = 0;
        for(int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public static List<String> swapFirstAndLast(List<String> strings) {

        String temp = strings.get(0);
        strings.set(0, strings.get( strings.size() - 1 ));
        strings.set( strings.size() - 1 ,temp);

        return strings;
    }

    public static List<Integer> reverse(List<Integer> numbers) {

        List<Integer> reversed = new ArrayList<>();

        for(int i = numbers.size()-1; i >=0; i--) {

            // size() - (i + 1) is the n-th to last element
            // so when i = 0, it would be the last element
            // when i = 3, it would be the fourth to last element since i=3 is the 4th element, etc
            reversed.add(numbers.get(i));
        }

        return reversed;
    }

    public static List<Integer> lessThanFive(List<Integer> numbers) {

        int numLessThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            }
        }

        if ( numLessThanFive == 0 ) {
            return null;
        }

        List<Integer> lessThan = new ArrayList<>();

        for(int num : numbers) {
            if ( num < 5 ) {

                // subtracting numLessThanFive from size() then decrementing numLessThanFive
                // allows us to go from 0 to size() - 1 in order without additional variables
                lessThan.add( num);
//                numLessThanFive--;
            }
        }

        return lessThan;
    }

    //challenge
    public static List<List<Integer>> splitAtFive(List<Integer> numbers) {
        int numLessThanFive = 0;
        int numMoreThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            } else {
                numMoreThanFive++;
            }
        }

        List<Integer> lessThan =new ArrayList<>();//= new int[numLessThanFive];
        List<Integer> moreThan =new ArrayList<>();//= new int[numMoreThanFive];


        for(int num : numbers) {

            // subtracting numLessThanFive from size() then decrementing numLessThanFive
            // allows us to go from 0 to size() - 1 in order without additional variables
            // same with numMoreThanFive
            if ( num < 5 ) {
                lessThan.add(num);
            } else {
                moreThan.add(num);
            }
        }
        List<List<Integer>> retList=new ArrayList<>();
        retList.add(lessThan);
        retList.add(moreThan);
        return retList;
    }

    // Challenge
    public static List<List<String>> evensAndOdds(List<String> strings) {

        //leveraging integer division
        List<String> odds = new ArrayList<>();

        // Set evens to null for reassignment below

        List<String> evens = new ArrayList<>();

        // again leveraging integer division
        // if it's already of even size(), we're good
        // but if it's of odd size(), there's one more even index than odd
//        if (strings.size() % 2 == 0) {
//            evens = new String[ strings.size()/2];
//        } else {
//            evens = new String[ strings.size()/2 + 1];
//        }

        for(int i = 0; i < strings.size(); i++) {
            //int currIndex = i/2;
            if( i % 2 == 0 ) {
                evens.add(strings.get(i));
            } else {
                odds.add(strings.get(i));
            }
        }
        List<List<String>> retList=new ArrayList<>();
        retList.add(evens);
        retList.add(odds);
        return retList;
    }
}
