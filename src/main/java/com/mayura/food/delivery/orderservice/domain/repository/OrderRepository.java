package com.mayura.food.delivery.orderservice.domain.repository;

import com.mayura.food.delivery.orderservice.domain.model.Order;

public interface OrderRepository {

    String createOrder(Order order);
}
