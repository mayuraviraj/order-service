package com.mayura.food.delivery.orderservice.infrastructure.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class LineItemVO {
    private String name;
    private BigDecimal amount;
}
