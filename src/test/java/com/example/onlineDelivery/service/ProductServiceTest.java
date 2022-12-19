package com.example.onlineDelivery.service;

import com.example.onlineDelivery.DTO.product.ProductRequest;
import com.example.onlineDelivery.DTO.product.ProductResponse;
import com.example.onlineDelivery.entity.Product;
import com.example.onlineDelivery.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ProductServiceTest {

    public static ProductService productService;

    public static ProductRepository productRepository;

    @BeforeAll
    public static void testDataInitializer(@Autowired ProductRepository productRepo){
        productRepository = productRepo;

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

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);


    }

    @BeforeEach
    public void setUpTestService(){
        productService = new ProductService(productRepository);
    }

    @Test
    void getAllProducts() {
        List<ProductResponse> productResponses = productService.getAllProducts();
        assertEquals(productResponses.size(), 4);

        assertNotEquals(productResponses.size(), 0);
        assertNotEquals(productResponses.size(), 3);
        assertNotEquals(productResponses.size(), 5);
    }

    @Test
    void getProductById() {
        ProductResponse productResponse = productService.getProductById(2);

        assertEquals(productResponse.getPrice(), 2.5);

        assertNotEquals(productResponse.getPrice(), 2.4);
        assertNotEquals(productResponse.getPrice(), 2.6);

        assertEquals(productResponse.getName(), "Apple");

        assertNotEquals(productResponse.getName(), "apple");

    }

    @Test
    void addProduct() {
        int listSize = 4;
        List<ProductResponse> productResponses = productService.getAllProducts();
        assertEquals(productResponses.size(), listSize);

        assertNotEquals(productResponses.size(), 3);
        assertNotEquals(productResponses.size(), 5);

        Product product = Product.builder()
                .name("Bacon")
                .price(20.0)
                .weight(150)
                .build();

        ProductRequest productRequest = new ProductRequest(product);
        productService.addProduct(productRequest);
        productResponses = productService.getAllProducts();

        assertEquals(productResponses.size(), listSize + 1);
        assertNotEquals(productResponses.size(), listSize);



    }

    @Test
    void editProduct() {
        ProductResponse productResponse = productService.getProductById(1);

        assertEquals(productResponse.getPrice(),10.0 );

        Product product = Product.builder()
                .id(1)
                .name("Milk")
                .price(12.0)
                .weight(1000)
                .build();

        ProductRequest productRequest = new ProductRequest(product);

        productService.editProduct(productRequest);


        ProductResponse editedProductResponse = productService.getProductById(1);

        assertNotEquals(productResponse.getPrice(), editedProductResponse.getPrice());

    }

    @Test
    void deleteProduct() {

        int listSize = 4;
        List<ProductResponse> productResponses = productService.getAllProducts();
        assertEquals(productResponses.size(), listSize);
        assertNotEquals(productResponses.size(), 3);


        productService.deleteProduct(2);
        productResponses = productService.getAllProducts();

        assertEquals(productResponses.size(), listSize - 1);
        assertNotEquals(productResponses.size(), listSize);

    }
}