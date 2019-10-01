package com.company;

import java.util.ArrayList;
import java.util.List;

public class ClassmatesList {
    private List<Classmate>classmates=new ArrayList<>();

    public void add(Classmate mate){
        classmates.add(mate);
    }

    public Classmate get(int ix){
        return classmates.get(ix);
    }

    public List<Classmate> getAll(){
        return classmates;
    }
}
