package com.example.onlineDelivery.DTO.product;

import com.example.onlineDelivery.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductRequest {
    private Integer id;
    private String name;
    private Double price;
    private Integer weight;

    public ProductRequest(Product product){
        this.id = product.getId();
        this. name = product.getName();
        this. price = product.getPrice();
        this.weight = product.getWeight();
    }

}
