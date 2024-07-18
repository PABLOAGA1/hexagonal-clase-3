package com.example.clase3.application.service;

import com.example.clase3.application.ports.out.OrderPort;
import com.example.clase3.domain.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class OrderServiceTest {
    @Mock
    OrderPort orderPort;


    @InjectMocks
    OrderService orderService ;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        final Order order = new Order(null, LocalDateTime.now(),"Mi primer Order");
        when(orderPort.saveOrder(Mockito.any(Order.class))).thenReturn(order);

        Order save = orderService.save(order);
        assertEquals(order.getDescription(),save.getDescription());
        verify(orderPort,Mockito.times(1)).saveOrder(order);
    }

    @Test
    void findAll() {

        Order order1 = new Order(1L, LocalDateTime.now(),"Order 1" );
        Order order2 = new Order(2L, LocalDateTime.now(),"Order 2" );
        List<Order> orders = Arrays.asList(order1, order2);

        // Mock behavior
        when(orderPort.findAllOrders()).thenReturn(orders);

        // Call method
        List<Order> result = orderService.findAll();

        // Verify
        assertEquals(2, result.size());
        assertEquals("Order 1", result.get(0).getDescription());
        assertEquals("Order 2", result.get(1).getDescription());
    }

    @Test
    void findById() {

        final Order order = new Order(1L, LocalDateTime.now(),"Mi primer Order");
        when(orderPort.findByIdOrder(1L)).thenReturn(Optional.of(order));

        Optional<Order> orderReturn = orderService.findById(1L);
        assertEquals(true,orderReturn.isPresent());
        assertEquals(order.getDescription(),orderReturn.get().getDescription());
        verify(orderPort,Mockito.times(1)).findByIdOrder(1L);



    }

    @Test
    void deleteById() {
        doNothing().when(orderPort).deleteByIdOrder(1L);

        orderService.deleteById(1L);

        verify(orderPort, times(1)).deleteByIdOrder(1L);
    }
}