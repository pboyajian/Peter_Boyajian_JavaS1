package com.trilogyed.PeterBoyajianCarLotJpaRepository.dao;

import com.trilogyed.PeterBoyajianCarLotJpaRepository.dto.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarLot extends JpaRepository<Car,Long> {
    List<Car> findByMake(String make);
    List<Car> findByColor(String color);
    List<Car> findByMakeAndColor(String make, String color);
}
