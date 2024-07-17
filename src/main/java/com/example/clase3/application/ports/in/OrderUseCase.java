package com.example.clase3.application.ports.in;

import com.example.clase3.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderUseCase {

    public com.example.clase3.domain.model.Order save(com.example.clase3.domain.model.Order order);

    public List<Order> findAll();


    public Optional<Order> findById(Long id);

    public void deleteById(Long id);
}
