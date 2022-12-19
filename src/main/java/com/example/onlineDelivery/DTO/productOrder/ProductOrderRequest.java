package com.example.onlineDelivery.DTO.productOrder;

import com.example.onlineDelivery.entity.ProductOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductOrderRequest {
    private Integer id;
    private Integer quantity;
    private Integer productId;
    private Integer deliveryId;


    public ProductOrderRequest(ProductOrder productOrder){
        this.id = productOrder.getId();
        this.quantity = productOrder.getQuantity();
        this.productId = productOrder.getProduct().getId();
        this.deliveryId = productOrder.getDelivery().getId();
    }
}
