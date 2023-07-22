package com.mayura.food.delivery.orderservice.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "line_item")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JpaLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    private JpaOrder jpaOrder;
    private String name;
    private BigDecimal amount;

}
