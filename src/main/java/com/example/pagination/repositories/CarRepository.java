package com.example.pagination.repositories;

import com.example.pagination.entity.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

//public interface CarRepository extends PagingAndSortingRepository<Car, Integer> { }

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findCarByBrand(Pageable pageable, String brand);
    List<Car> findCarByModel(Pageable pageable, String model);
    List<Car> findCarByColor(Pageable pageable, String color);
    List<Car> findCarByKilometers(Pageable pageable, String kilometers);
}
