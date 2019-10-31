package com.trilogyed;

import java.util.*;

import static java.util.Collections.max;

/**
 * Write tests for, and then implement a method that returns a set (no repeats) of strings that occur with the most
 * frequency from a list of strings.
 * If there is a tie (more than one string share max occurrences), then each string that has max occurrences will
 * be in the set.
 * If the input list is null, or empty, the result is an empty set.
 *
 * So,
 * the input ("like", "um", "like") returns the set ("like")
 * the input ("I", "I", "I", "42", "42", "42") returns the set ("42", "I")
 * the input ("apple", "Apple") returns the set ("apple", "Apple")
 * the input () returns the set ()
 */
public class MostFrequentString {
    public static void main(String[] args) {
        MostFrequentString mostFrequentString = new MostFrequentString();
        List<String> inputList1 = new LinkedList<>();
        inputList1.add("like");
        inputList1.add("like");
        inputList1.add("um");
        System.out.println("The instructions say this should return a set that just has the word \"like\" in it... " +
                mostFrequentString.findMostFrequent(inputList1));

        Vector<String> vector = new Vector<>();
        vector.add("I");
        vector.add("I");
        vector.add("I");
        vector.add("42");
        vector.add("42");
        vector.add("42");

        System.out.println("The instructions say this should return a set that has the strings \"I\" and \"42\" in it... " +
                mostFrequentString.findMostFrequent(vector));

        System.out.println("The instructions say this should return a set that has two apples in it... " +
                mostFrequentString.findMostFrequent(Arrays.asList("Apple", "apple")));

    }

    public Set<String> findMostFrequent(List<String> inputList1) {
        Map<String,Integer> map=new HashMap<>();
        int max=0;
        for(String a:inputList1){
            if (map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else{
                map.put(a,1);
            }
            max=Math.max(map.get(a),max);
        }
        Set<String> retSet=new HashSet<>();
        for(String a:map.keySet()){
            if (map.get(a)==max){
                retSet.add(a);
            }
        }
        return retSet;

    }


    }

