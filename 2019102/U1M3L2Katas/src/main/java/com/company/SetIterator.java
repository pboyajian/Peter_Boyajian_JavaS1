package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIterator {
    public void printSet(int a,int b,int c,int d, int e){
        Set<Integer> hash=new HashSet<>();
        hash.addAll(Arrays.asList(a,b,c,d,e));
        Iterator<Integer> iterator=hash.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
