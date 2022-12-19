package com.example.onlineDelivery.DTO.van;

import com.example.onlineDelivery.entity.Van;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VanResponse {
    private Integer id;
    private String brand;
    private String model;
    private Integer capacity;

    public VanResponse(Van van){
        this.id = van.getId();
        this.brand = van.getBrand();
        this.model = van.getModel();
        this.capacity = van.getCapacity();
    }
}
