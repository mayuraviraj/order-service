package com.mayura.food.delivery.orderservice.infrastructure.web;

import com.mayura.food.delivery.orderservice.domain.model.LineItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderVO {
    private int orderNumber;
    private String customerId;
    private String restaurantId;
    private List<LineItemVO> items;
}
