package com.example.pagination.service;

import com.example.pagination.DTO.CarResponse;
import com.example.pagination.entity.Car;
import com.example.pagination.repositories.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public List<CarResponse> getCars() {
        List<Car> cars = carRepository.findAll();

        return cars.stream().map(car -> new CarResponse(car)).toList();
    }
    public List<CarResponse> getCarsPageable(Pageable pageable) {
        Page<Car> cars = carRepository.findAll(pageable);
        return cars.stream().map(car -> new CarResponse(car)).toList();
    }



    public List<CarResponse> getCarsFilter(String column, String val, Pageable pageable){
        return switch (column){
            case "brand" ->  carRepository.findCarByBrand(pageable, val).stream().map(CarResponse::new).collect(Collectors.toList());
            case "model" -> carRepository.findCarByModel(pageable, val).stream().map(CarResponse::new).collect(Collectors.toList());
            case "color"-> carRepository.findCarByColor(pageable, val).stream().map(CarResponse::new).collect(Collectors.toList());

            default -> null;
        };

    }

}
