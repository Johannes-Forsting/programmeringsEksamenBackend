package com.example.onlineDelivery.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Van {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String brand;

    @Column(nullable = false, length = 100)
    private String model;


    //in grams
    @Column(nullable = false)
    private Integer capacity;


    @OneToMany(mappedBy = "van", cascade =  CascadeType.ALL)
    private List<Delivery> deliveries;




}
