package com.mayura.food.delivery.orderservice.infrastructure.web;

import com.mayura.food.delivery.orderservice.application.OrderService;
import com.mayura.food.delivery.orderservice.domain.model.LineItem;
import com.mayura.food.delivery.orderservice.domain.model.Order;
import com.mayura.food.delivery.orderservice.domain.model.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/order/")
@Slf4j
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    ResponseEntity<String> createOrder(@RequestBody OrderVO orderVO) {
        log.info("Creating new order [{}]", orderVO);
        Order order = mapToOrder(orderVO);
        return new ResponseEntity<>(orderService.createOrder(order),
                HttpStatus.ACCEPTED);
    }

    private Order mapToOrder(OrderVO orderVO) {
        return Order.builder()
                .orderStatus(OrderStatus.ACCEPTED)
                .customerId(orderVO.getCustomerId())
                .restaurantId(orderVO.getRestaurantId())
                .items(mapToLineItems(orderVO.getItems()))
                .build();
    }

    private List<LineItem> mapToLineItems(List<LineItemVO> items) {
        return items.stream().map(this::mapToLineItem).collect(Collectors.toList());
    }

    private LineItem mapToLineItem(LineItemVO t) {
        return LineItem.builder().amount(t.getAmount())
                .name(t.getName()).build();
    }
}
