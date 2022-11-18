package com.example.pagination.api;

import com.example.pagination.DTO.CarResponse;
import com.example.pagination.entity.Car;
import com.example.pagination.service.CarService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/cars")
public class CarController {

    CarService carService;

    public CarController(CarService carService) {

        this.carService = carService;
    }

    @GetMapping
    List<CarResponse> getCars(){
        return carService.getCars();
    }

    @GetMapping("/pageable")
    List<CarResponse> getCarsPageable(Pageable p){
        return carService.getCarsPageable(p);
    }

    @GetMapping("/filter")
    List<CarResponse> getBrandPageable(@RequestParam("column") String column, @RequestParam("value") String value, Pageable pageable){
        return carService.getCarsFilter(column, value, pageable);
    }








}
