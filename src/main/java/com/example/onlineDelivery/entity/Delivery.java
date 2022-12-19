package com.example.onlineDelivery.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate deliveryDate;

    @Column(nullable = false, length = 100)
    private String fromWarehouse;

    @Column(nullable = false, length = 100)
    private String destination;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<ProductOrder> productOrders;

    @ManyToOne
    private Van van;
}
