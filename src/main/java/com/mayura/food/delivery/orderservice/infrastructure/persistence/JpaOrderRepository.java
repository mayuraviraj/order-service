package com.mayura.food.delivery.orderservice.infrastructure.persistence;

import com.mayura.food.delivery.orderservice.domain.model.LineItem;
import com.mayura.food.delivery.orderservice.domain.model.Order;
import com.mayura.food.delivery.orderservice.domain.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class JpaOrderRepository implements OrderRepository {

    private final JpaOrderInternalRepo jpaOrderInternalRepo;

    public JpaOrderRepository(JpaOrderInternalRepo jpaOrderInternalRepo) {
        this.jpaOrderInternalRepo = jpaOrderInternalRepo;
    }

    @Override
    public String createOrder(Order order) {
        JpaOrder jpaOrder = mapToJPAOrder(order);
        log.info("Saving order [{}]", jpaOrder);
        JpaOrder savedData = jpaOrderInternalRepo.save(jpaOrder);
        return savedData.getId();
    }

    private JpaOrder mapToJPAOrder(Order order) {
        return JpaOrder.builder()
                .orderNumber(order.getOrderNumber())
                .orderStatus(order.getOrderStatus())
                .customerId(order.getCustomerId())
                .restaurantId(order.getRestaurantId())
                .items(mapToJPALineItems(order.getItems()))
                .build();
    }

    private List<JpaLineItem> mapToJPALineItems(List<LineItem> items) {
        return items.stream().map(this::mapToJPALineItem).collect(Collectors.toList());
    }

    private JpaLineItem mapToJPALineItem(LineItem item) {
        return JpaLineItem.builder()
                .amount(item.getAmount())
                .name(item.getName())
                .build();
    }
}
