package com.example.clase3.adapters.out.persistence;

import com.example.clase3.domain.model.Order;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static io.smallrye.common.constraint.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JpaOrderRepositoryTest {
    @InjectMocks
    JpaOrderRepository  orderRepository;
    @InjectMocks
    EntityManager entityManager;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveOrder() {
        /*Order order = new Order(null,  LocalDateTime.now(),"Test Order");
        Order newOrder = orderRepository.saveOrder(order);
        entityManager.flush();
        entityManager.clear();

        Optional<Order> savedOrder = orderRepository.findByIdOrder(newOrder.getId());
        assertTrue(savedOrder.isPresent());
        assertEquals(order.getDescription(), savedOrder.get().getDescription());*/
    }

    @Test
    void findAllOrders() {
    }

    @Test
    void findByIdOrder() {
    }

    @Test
    void deleteByIdOrder() {
    }
}