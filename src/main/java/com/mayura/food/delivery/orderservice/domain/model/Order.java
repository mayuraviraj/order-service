package com.mayura.food.delivery.orderservice.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private String id;
    private String restaurantId;
    private String customerId;
    private int orderNumber;
    private List<LineItem> items;
    private OrderStatus orderStatus;

}
