package com.example.onlineDelivery.DTO.productOrder;

import com.example.onlineDelivery.DTO.delivery.DeliveryResponse;
import com.example.onlineDelivery.DTO.product.ProductResponse;
import com.example.onlineDelivery.entity.ProductOrder;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOrderResponse {
    private Integer id;
    private Integer quantity;
    private ProductResponse productResponse;
    private DeliveryResponse deliveryResponse;


    public ProductOrderResponse(ProductOrder productOrder){
        this.id = productOrder.getId();
        this.quantity = productOrder.getQuantity();
        this.productResponse = new ProductResponse(productOrder.getProduct());
        this.deliveryResponse = new DeliveryResponse(productOrder.getDelivery());
    }
}
