package com.mayura.food.delivery.orderservice.application;

import com.mayura.food.delivery.orderservice.domain.model.Order;

public interface OrderService {

    String createOrder(Order order);
}
