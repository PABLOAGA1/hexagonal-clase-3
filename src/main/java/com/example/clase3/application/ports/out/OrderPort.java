package com.example.clase3.application.ports.out;

import com.example.clase3.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderPort {

    Order saveOrder(Order order);

    List<Order> findAllOrders();


    Optional<Order> findByIdOrder(Long id);

    void deleteByIdOrder(Long id);
}
