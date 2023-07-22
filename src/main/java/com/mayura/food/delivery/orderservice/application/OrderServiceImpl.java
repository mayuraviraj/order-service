package com.mayura.food.delivery.orderservice.application;

import com.mayura.food.delivery.orderservice.domain.model.Order;
import com.mayura.food.delivery.orderservice.domain.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public String createOrder(Order order) {
        log.info("Creating new order [{}]", order);
        return orderRepository.createOrder(order);
    }
}
