package com.company;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class TelevisionReader {

    public static void main(String[] args) {
        // CODE GOES HERE
        List<Television> tvs=new ArrayList<>();
        try{tvs=FileIO.getTelevisions("televisions.csv");}
        catch(FileNotFoundException e){
            System.out.println("File not found: "+e.getMessage());
        }
        tvs.stream().filter(n->n.
                getScreenSize()>60).
                forEach(n-> System.out.println(n));


        Map<String,List<Television>> map=tvs.stream().collect(Collectors.groupingBy(b->b.getBrand()));
        System.out.println(map.keySet());
        OptionalDouble avgScreenSize=tvs.stream().mapToInt(n->n.getScreenSize()).average();
        if(avgScreenSize.isPresent()){
        System.out.println("Average Screen Size: "+avgScreenSize.getAsDouble());}

        OptionalInt maxScreenSize=tvs.stream().mapToInt(n->n.getScreenSize()).max();
        if(maxScreenSize.isPresent()){
            System.out.println("Max Screen Size: "+maxScreenSize.getAsInt());}

        tvs.stream().sorted((o1,o2)->o2.getScreenSize()-o1.getScreenSize()).forEach(n-> System.out.println(n));

//        Map<String,List<Television>> map=new HashMap<>();
//        Set<String> brands=new HashSet<>();
//        tvs.stream().forEach(n->brands.add(n.getBrand()));
//        List<Television> finalTvs = tvs;
//        brands.stream().forEach(brand->map
//                .put(brand, finalTvs
//                        .stream()
//                        .filter(n->n.getBrand().equals(brand))
//                        .collect(Collectors.toList())));
//        System.out.println("Brands: ");
//        System.out.println(map.keySet());

       // List<Integer> screenSizes=tvs.stream().mapToInt(n->n.getScreenSize()).collect(Collectors.toList());
//        System.out.println("The average screen size is: "+tvs.stream().collect());

            
        }
    }

