package com.example.pagination.DTO;

import com.example.pagination.entity.Car;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {

    Integer id;
    String brand;
    String model;
    String color;
    Integer kilometers;

    public CarResponse(Car car) {
        this.id = car.getId();
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.color = car.getColor();
        this.kilometers = car.getKilometers();
    }
}
