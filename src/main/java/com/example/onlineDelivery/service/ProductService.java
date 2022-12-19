package com.example.onlineDelivery.service;

import com.example.onlineDelivery.DTO.product.ProductRequest;
import com.example.onlineDelivery.DTO.product.ProductResponse;
import com.example.onlineDelivery.entity.Product;
import com.example.onlineDelivery.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> new ProductResponse(product)).toList();
    }


    public ProductResponse getProductById(Integer id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with this id: " + id + " could not be found"));
        return new ProductResponse(product);
    }

    public ProductResponse addProduct(ProductRequest productRequest){
        Product newProduct = Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .weight(productRequest.getWeight())
                .build();
        productRepository.save(newProduct);
        return new ProductResponse(newProduct);
    }



    public ProductResponse editProduct(ProductRequest productRequest){
        Product product = productRepository.findById(productRequest.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with this id: " + productRequest.getId() + " could not be found"));
        if(productRequest.getName() != null){
            product.setName(productRequest.getName());
        }
        if(productRequest.getPrice() != null){
            product.setPrice(productRequest.getPrice());
        }
        if(productRequest.getName() != null){
            product.setName(productRequest.getName());
        }
        if(productRequest.getName() != null){
            product.setName(productRequest.getName());
        }

        productRepository.save(product);
        return new ProductResponse(product);
    }

    public ProductResponse deleteProduct(Integer id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with this id: " + id + " could not be found"));
        productRepository.deleteById(id);
        return new ProductResponse(product);
    }








}
