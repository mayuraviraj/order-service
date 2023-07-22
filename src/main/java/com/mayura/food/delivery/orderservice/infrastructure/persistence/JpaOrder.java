package com.mayura.food.delivery.orderservice.infrastructure.persistence;

import com.mayura.food.delivery.orderservice.domain.model.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "customer_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JpaOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String restaurantId;
    private String customerId;
    private int orderNumber;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "jpaOrder"
    )
    private List<JpaLineItem> items;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
