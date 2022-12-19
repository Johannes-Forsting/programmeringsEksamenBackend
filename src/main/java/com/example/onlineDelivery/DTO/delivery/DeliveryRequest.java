package com.example.onlineDelivery.DTO.delivery;

import com.example.onlineDelivery.DTO.product.ProductRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.lang.model.type.IntersectionType;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DeliveryRequest {
    private Integer id;
    private LocalDate deliveryDate;
    private String fromWarehouse;
    private String destination;
    private Integer vanId;


}
