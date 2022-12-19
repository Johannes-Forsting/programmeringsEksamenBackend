package com.example.onlineDelivery.configuration;


import com.example.onlineDelivery.entity.Delivery;
import com.example.onlineDelivery.entity.Product;
import com.example.onlineDelivery.entity.ProductOrder;
import com.example.onlineDelivery.entity.Van;
import com.example.onlineDelivery.repositories.DeliveryRepository;
import com.example.onlineDelivery.repositories.ProductOrderRepository;
import com.example.onlineDelivery.repositories.ProductRepository;
import com.example.onlineDelivery.repositories.VanRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
public class Setup implements ApplicationRunner {
    ProductRepository productRepository;
    ProductOrderRepository productOrderRepository;

    DeliveryRepository deliveryRepository;
    VanRepository vanRepository;

    public Setup(ProductRepository productRepository, ProductOrderRepository productOrderRepository, DeliveryRepository deliveryRepository, VanRepository vanRepository){
        this.productRepository = productRepository;
        this.productOrderRepository = productOrderRepository;
        this.deliveryRepository = deliveryRepository;
        this.vanRepository = vanRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //=====================Products=====================
        Product product1 = Product.builder()
                .name("Milk")
                .price(10.0)
                .weight(1000)
                .build();
        Product product2 = Product.builder()
                .name("Apple")
                .price(2.5)
                .weight(150)
                .build();
        Product product3 = Product.builder()
                .name("Meat")
                .price(50.0)
                .weight(400)
                .build();
        Product product4 = Product.builder()
                .name("Bread")
                .price(15.0)
                .weight(300)
                .build();
        Product product5 = Product.builder()
                .name("Cheese")
                .price(30.0)
                .weight(200)
                .build();
        Product product6 = Product.builder()
                .name("Can tomatoes")
                .price(4.0)
                .weight(400)
                .build();
        Product product7 = Product.builder()
                .name("Candy")
                .price(25.5)
                .weight(275)
                .build();
        Product product8 = Product.builder()
                .name("Coca cola")
                .price(15.5)
                .weight(1500)
                .build();
        Product product9 = Product.builder()
                .name("Cereal")
                .price(45.0)
                .weight(500)
                .build();
        Product product10 = Product.builder()
                .name("Bacon")
                .price(30.0)
                .weight(250)
                .build();

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);
        productRepository.save(product9);
        productRepository.save(product10);

        //=====================PRODUCTS END=====================


        //=====================VAN=====================
        Van van1 = Van.builder()
                .brand("Kia")
                .model("Bongo")
                .capacity(1000000)
                .build();

        Van van2 = Van.builder()
                .brand("Opel")
                .model("Astravan")
                .capacity(1500000)
                .build();

        Van van3 = Van.builder()
                .brand("Seat")
                .model("Inca")
                .capacity(900000)
                .build();

        vanRepository.save(van1);
        vanRepository.save(van2);
        vanRepository.save(van3);


        //=====================VAN END=====================



        //=====================DELIVERY=====================
        Delivery delivery1 = Delivery.builder()
                .deliveryDate(LocalDate.of(2022, 12, 24))
                .fromWarehouse("Brøndby")
                .destination("Kea keasvej 12")
                .van(van1)
                .build();
        Delivery delivery2 = Delivery.builder()
                .deliveryDate(LocalDate.of(2023, 1, 1))
                .fromWarehouse("Brøndby")
                .destination("Kea keasvej 01")
                .van(van2)
                .build();

        deliveryRepository.save(delivery1);
        deliveryRepository.save(delivery2);

        //=====================DELIVERY END=====================

        //=====================PRODUCTORDER=====================
        ProductOrder productOrder1 = ProductOrder.builder()
                .quantity(4)
                .build();

        ProductOrder productOrder2 = ProductOrder.builder()
                .product(product2)
                .quantity(1)
                .delivery(delivery1)
                .build();

        ProductOrder productOrder3 = ProductOrder.builder()
                .product(product9)
                .quantity(2)
                .delivery(delivery2)
                .build();



        productOrderRepository.save(productOrder1);
        productOrder1.setProduct(product2);
        productOrder1.setDelivery(delivery1);
        productOrderRepository.save(productOrder1);
        productOrderRepository.save(productOrder2);
        productOrderRepository.save(productOrder3);


        //=====================PRODUCTORDER END=====================




    }




}
