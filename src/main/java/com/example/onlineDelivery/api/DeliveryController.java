package com.example.onlineDelivery.api;


import com.example.onlineDelivery.DTO.delivery.DeliveryRequest;
import com.example.onlineDelivery.DTO.delivery.DeliveryResponse;
import com.example.onlineDelivery.DTO.product.ProductRequest;
import com.example.onlineDelivery.DTO.product.ProductResponse;
import com.example.onlineDelivery.entity.Delivery;
import com.example.onlineDelivery.service.DeliveryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/deliveries")
public class DeliveryController {

    DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public List<DeliveryResponse> getAllDeliveries(){
        return deliveryService.getAllDeliveries();
    }
    @GetMapping("/{id}")
    public DeliveryResponse getDeliveryById(@PathVariable Integer id){
        return deliveryService.getDeliveryById(id);
    }

    @PostMapping
    public DeliveryResponse addDelivery(@RequestBody DeliveryRequest deliveryRequest){
        return deliveryService.addDelivery(deliveryRequest);
    }
    @PutMapping
    public DeliveryResponse editDelivery(@RequestBody DeliveryRequest deliveryRequest){
        return deliveryService.editDelivery(deliveryRequest);

    }


    @DeleteMapping("/{id}")
    public DeliveryResponse deleteDeliveryById(@PathVariable Integer id){
        return deliveryService.deleteDelivery(id);
    }






}
