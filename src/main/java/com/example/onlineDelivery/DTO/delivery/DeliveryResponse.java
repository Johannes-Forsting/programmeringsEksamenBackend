package com.example.onlineDelivery.DTO.delivery;

import com.example.onlineDelivery.DTO.van.VanResponse;
import com.example.onlineDelivery.entity.Delivery;
import com.example.onlineDelivery.entity.Van;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryResponse {

    private Integer id;
    private LocalDate deliveryDate;
    private String fromWarehouse;
    private String destination;
    private VanResponse vanResponse;

    public DeliveryResponse(Delivery delivery){
        this.id = delivery.getId();
        this.deliveryDate = delivery.getDeliveryDate();
        this.fromWarehouse = delivery.getFromWarehouse();
        this.destination = delivery.getDestination();
        if(delivery.getVan() != null){
            this.vanResponse = new VanResponse(delivery.getVan());
        }else {
            this.vanResponse = null;
        }
    }
}
