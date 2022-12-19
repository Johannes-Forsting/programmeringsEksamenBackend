package com.example.onlineDelivery.service;

import com.example.onlineDelivery.DTO.delivery.DeliveryRequest;
import com.example.onlineDelivery.DTO.delivery.DeliveryResponse;
import com.example.onlineDelivery.DTO.product.ProductRequest;
import com.example.onlineDelivery.DTO.product.ProductResponse;
import com.example.onlineDelivery.entity.Delivery;
import com.example.onlineDelivery.entity.Product;
import com.example.onlineDelivery.entity.Van;
import com.example.onlineDelivery.repositories.DeliveryRepository;
import com.example.onlineDelivery.repositories.VanRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DeliveryService {


    DeliveryRepository deliveryRepository;
    VanRepository vanRepository;

    public DeliveryService(DeliveryRepository deliveryRepository, VanRepository vanRepository){
        this.deliveryRepository = deliveryRepository;
        this.vanRepository = vanRepository;
    }

    public List<DeliveryResponse> getAllDeliveries() {
        List<Delivery> deliveries = deliveryRepository.findAll();

        return deliveries.stream().map(delivery -> new DeliveryResponse(delivery)).toList();
    }

    public DeliveryResponse getDeliveryById(Integer id){
        Delivery delivery = deliveryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Delivery with this id: " + id + " could not be found"));
        return new DeliveryResponse(delivery);
    }


    public DeliveryResponse addDelivery(DeliveryRequest deliveryRequest){
        System.out.println();
        Delivery newDelivery = Delivery.builder()
                .deliveryDate(deliveryRequest.getDeliveryDate())
                .fromWarehouse(deliveryRequest.getFromWarehouse())
                .destination(deliveryRequest.getDestination())
                .build();

        if(deliveryRequest.getVanId() != null){
            Van van = vanRepository.findById(deliveryRequest.getVanId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Van with this id: " + deliveryRequest.getVanId() + " could not be found"));
            newDelivery.setVan(van);
        }
        deliveryRepository.save(newDelivery);
        return new DeliveryResponse(newDelivery);
    }


    public DeliveryResponse deleteDelivery(Integer id){
        Delivery delivery = deliveryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Delivery with this id: " + id + " could not be found"));
        deliveryRepository.deleteById(id);
        return new DeliveryResponse(delivery);
    }


    public DeliveryResponse editDelivery(DeliveryRequest deliveryRequest) {
        Delivery delivery = deliveryRepository.findById(deliveryRequest.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Delivery with this id: " + deliveryRequest.getId() + " could not be found"));
        Van van = vanRepository.findById(deliveryRequest.getVanId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Van with this id: " + deliveryRequest.getVanId() + " could not be found"));

        delivery.setVan(van);
        deliveryRepository.save(delivery);
        return new DeliveryResponse(delivery);
    }
}
