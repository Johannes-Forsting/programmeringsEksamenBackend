package com.example.onlineDelivery.DTO.product;

import com.example.onlineDelivery.entity.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
    private Integer id;
    private String name;
    private Double price;
    private Integer weight;


    public ProductResponse(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.weight = product.getWeight();
    }
}
