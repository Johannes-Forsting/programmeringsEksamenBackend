package com.example.onlineDelivery.repositories;

import com.example.onlineDelivery.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

    List<ProductOrder> findAllByDeliveryId(Integer id);

}
