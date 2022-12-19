package com.example.onlineDelivery.service;

import com.example.onlineDelivery.DTO.productOrder.ProductOrderRequest;
import com.example.onlineDelivery.DTO.productOrder.ProductOrderResponse;
import com.example.onlineDelivery.entity.Delivery;
import com.example.onlineDelivery.entity.Product;
import com.example.onlineDelivery.entity.ProductOrder;
import com.example.onlineDelivery.repositories.DeliveryRepository;
import com.example.onlineDelivery.repositories.ProductOrderRepository;
import com.example.onlineDelivery.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductOrderService {

    ProductOrderRepository productOrderRepository;

    ProductRepository productRepository;

    DeliveryRepository deliveryRepository;

    public ProductOrderService(ProductOrderRepository productOrderRepository, ProductRepository productRepository, DeliveryRepository deliveryRepository){
        this.productOrderRepository = productOrderRepository;
        this.productRepository = productRepository;
        this.deliveryRepository = deliveryRepository;
    }

    public List<ProductOrderResponse> getAllProductOrders(){
        List<ProductOrder> productOrders = productOrderRepository.findAll();
        return productOrders.stream().map(productOrder -> new ProductOrderResponse(productOrder)).toList();
    }

    public List<ProductOrderResponse> getAllProductOrdersByDeliveryId(Integer id){
        List<ProductOrder> productOrders = productOrderRepository.findAllByDeliveryId(id);
        return productOrders.stream().map(productOrder -> new ProductOrderResponse(productOrder)).toList();

    }


    public ProductOrderResponse deleteById(Integer id) {
        ProductOrder productOrder = productOrderRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ProductOrder with this id: " + id + " could not be found"));
        productOrderRepository.deleteById(id);
        return new ProductOrderResponse(productOrder);
    }


    public ProductOrderResponse addNewProductOrder(ProductOrderRequest productOrderRequest) {
        Product product = productRepository.findById(productOrderRequest.getProductId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with this id: " + productOrderRequest.getProductId() + " could not be found"));
        Delivery delivery = deliveryRepository.findById(productOrderRequest.getDeliveryId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Delivery with this id: " + productOrderRequest.getDeliveryId() + " could not be found"));

        ProductOrder newProductOrder = ProductOrder.builder()
                .quantity(productOrderRequest.getQuantity())
                .product(product)
                .delivery(delivery)
                .build();
        productOrderRepository.save(newProductOrder);
        return new ProductOrderResponse(newProductOrder);
    }
}
