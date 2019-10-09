package com.company.recordstore.controller;

import com.company.recordstore.exceptions.NotFoundException;
import com.company.recordstore.models.Record;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController

public class RecordStoreController {

    // TO DO
    private List<Record> recordList;
    public RecordStoreController(){
        recordList=new ArrayList<>();
        recordList.add(new Record("Eagles","Greatest Hits1",1));
        recordList.add(new Record("Eagles2","Greatest Hits2",2));
        recordList.add(new Record("Eagles3","Greatest Hits3",3));
        recordList.add(new Record("Eagles4","Greatest Hits4",4));
    }
    @RequestMapping(value="/records",method = RequestMethod.GET)
    public List<Record> getRecordList(){

        return recordList;
    }

    @PostMapping(value="/records")
    @ResponseStatus(HttpStatus.CREATED)
    public Record createNewRecord(@RequestBody @Valid Record record){
if (record.getId()<0){
        throw new IllegalArgumentException("invalid id"); }
        recordList.add(record);
        return record;
    }

    @RequestMapping(value="/records/{ix}",method = RequestMethod.GET)
    //@ResponseStatus(HttpStatus.NOT_FOUND)
    public Record getRecordById(@PathVariable int ix){

        if (ix<0){
            throw new NotFoundException("not found");}

        for (Record record:recordList){
            if (record.getId()==ix){
                return record;
            }}
        return null;
    }
    @PutMapping(value="/records/{ix}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Record updateExistingRecord(@RequestBody @Valid Record record,@PathVariable  int ix){
        if (record.getId()<0){
            throw new IllegalArgumentException("invalid id"); }
        recordList.set(ix-1, record);
        return recordList.get(ix-1);
    }

    @RequestMapping(value="/records/{ix}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecordById(@PathVariable int ix){
recordList=recordList.stream().filter(c->c.getId()!=ix).collect(Collectors.toList());
    }

}
