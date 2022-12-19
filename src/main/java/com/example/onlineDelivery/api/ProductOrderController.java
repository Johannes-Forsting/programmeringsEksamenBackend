package com.example.onlineDelivery.api;


import com.example.onlineDelivery.DTO.productOrder.ProductOrderRequest;
import com.example.onlineDelivery.DTO.productOrder.ProductOrderResponse;
import com.example.onlineDelivery.entity.ProductOrder;
import com.example.onlineDelivery.service.ProductOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/product-orders")
public class ProductOrderController {

    ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService){
        this.productOrderService = productOrderService;
    }

    @GetMapping
    public List<ProductOrderResponse> getAllProductOrders(){
        return productOrderService.getAllProductOrders();
    }

    @GetMapping("/by-delivery-id/{id}")
    public List<ProductOrderResponse> getAllProductOrdersByDeliveryId(@PathVariable Integer id){
        return productOrderService.getAllProductOrdersByDeliveryId(id);
    }

    @PostMapping
    public ProductOrderResponse addNewProductOrder(@RequestBody ProductOrderRequest productOrderRequest){

        return productOrderService.addNewProductOrder(productOrderRequest);
    }




    @DeleteMapping("/{id}")
    public ProductOrderResponse deleteProductOrderById(@PathVariable Integer id){

        return productOrderService.deleteById(id);
    }
}
