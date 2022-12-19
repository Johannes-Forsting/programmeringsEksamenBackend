package com.example.onlineDelivery.api;

import com.example.onlineDelivery.DTO.product.ProductRequest;
import com.example.onlineDelivery.DTO.product.ProductResponse;
import com.example.onlineDelivery.entity.Product;
import com.example.onlineDelivery.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> getProducts(){
        return productService.getAllProducts();
    }


    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductResponse addProduct(@RequestBody ProductRequest productRequest){
        return productService.addProduct(productRequest);
    }

    @PutMapping
    public ProductResponse editProduct(@RequestBody ProductRequest productRequest){
        return productService.editProduct(productRequest);
    }

    @DeleteMapping("/{id}")
    public ProductResponse deleteProductById(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }

}
