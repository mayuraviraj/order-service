package com.mayura.food.delivery.orderservice.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LineItem {
    private String id;
    private Order order;
    private String name;
    private BigDecimal amount;

}
