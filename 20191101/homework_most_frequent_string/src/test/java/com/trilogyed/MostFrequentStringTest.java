package com.trilogyed;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class MostFrequentStringTest {
    private MostFrequentString mostFrequentString;
    @Test
    public void shouldReturnMostFrequentWhenUnique(){
        mostFrequentString=new MostFrequentString();
        List<String> inputList1 = new LinkedList<>();
        inputList1.add("like");
        inputList1.add("like");
        inputList1.add("um");
        Set<String> expectedSet=new HashSet<>();
        expectedSet.add("like");
        Set<String> actualSet=mostFrequentString.findMostFrequent(inputList1);
        assertEquals(expectedSet,actualSet);
    }
    @Test
    public void shouldReturnMostFrequentWhenNotUnique(){
        mostFrequentString=new MostFrequentString();
        List<String> inputList1 = new LinkedList<>();
        inputList1.add("like");
        inputList1.add("like");
        inputList1.add("um");
        inputList1.add("um");
        inputList1.add("ummmmmm");
        Set<String> expectedSet=new HashSet<>();
        expectedSet.add("like");
        expectedSet.add("um");
        Set<String> actualSet=mostFrequentString.findMostFrequent(inputList1);
        assertEquals(expectedSet,actualSet);
    }

}