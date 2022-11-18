package com.example.pagination.entity;

import com.example.pagination.DTO.CarResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Car {

    @Id
    private int id;

    private String brand;

    private String model;

    private String color;

    private int kilometers;





}
