package com.trilogyed.cityservice.controller;

import com.trilogyed.cityservice.exceptions.InvalidCityNameException;
import com.trilogyed.cityservice.models.City;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CityServiceController {

    private List<City> cityList;

    public CityServiceController() {
        cityList=new ArrayList<>();
        cityList.add(new City("City1","State1",1,true));
        cityList.add(new City("City2","State2",2));
        cityList.add(new City("City3","State3",3,true));
        cityList.add(new City("City4","State4",4));
        cityList.add(new City("City5","State5",5,true));
        cityList.add(new City("City6","State6",6));
        cityList.add(new City("City7","State7",7,true));
        cityList.add(new City("City8","State8",8));
        cityList.add(new City("City9","State9",9,true));
    }

    @RequestMapping(value="/city",method = RequestMethod.GET)
    public List<City> getCityList(){
        return cityList;
    }

    @PostMapping(value="/city")
    @ResponseStatus(HttpStatus.CREATED)
    public City createNewCity(@RequestBody City city){
        cityList.add(city);
        return city;
    }

    @RequestMapping(value="/city/{name}",method = RequestMethod.GET)
    //@ResponseStatus(HttpStatus.NOT_FOUND)
    public City getCityById(@PathVariable String name){
String tempName;
        for (City city:cityList){
          tempName=city.getName();
            if (tempName.equalsIgnoreCase(name)){
                return city;
            }}
        throw new InvalidCityNameException("That is not a valid city name!");
    }

    @RequestMapping(value="/city/{name}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCityById(@PathVariable String name){
cityList=cityList.stream().filter(z->z.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }
}
