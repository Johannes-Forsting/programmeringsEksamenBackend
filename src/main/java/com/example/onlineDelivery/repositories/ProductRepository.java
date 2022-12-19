package com.example.onlineDelivery.repositories;

import com.example.onlineDelivery.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
