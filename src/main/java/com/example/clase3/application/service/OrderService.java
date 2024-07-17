package com.example.clase3.application.service;

import com.example.clase3.application.ports.in.OrderUseCase;
import com.example.clase3.application.ports.out.OrderPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrderService implements OrderUseCase {

    OrderPort orderRepository;
    @Inject
    public OrderService(OrderPort orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public com.example.clase3.domain.model.Order save(com.example.clase3.domain.model.Order order){
        return orderRepository.saveOrder(order);

    }
    @Override
    public List<com.example.clase3.domain.model.Order> findAll(){

        return orderRepository.findAllOrders();
    }

    @Override
    public Optional<com.example.clase3.domain.model.Order> findById(Long id){
        return orderRepository.findByIdOrder(id);
    }
    @Override
    public void deleteById(Long id){
        orderRepository.deleteByIdOrder(id);
    }
}
