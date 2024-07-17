package com.example.clase3.adapters.out.persistence;

import com.example.clase3.application.ports.out.OrderPort;
import com.example.clase3.domain.model.Order;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class JpaOrderRepository implements OrderPort {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Order saveOrder(Order order) {
        if (order.getId()==null){

            entityManager.persist(order);
            return order;
        } else {
            return entityManager.merge(order);
        }

    }

    @Override
    public List<Order> findAllOrders() {
        return entityManager.createQuery("SELECT o from Order o",Order.class).getResultList();
    }

    @Override
    public Optional<Order> findByIdOrder(Long id) {
        return Optional.ofNullable(entityManager.find(Order.class,id));
    }

    @Override
    public void deleteByIdOrder(Long id) {
        entityManager.remove(entityManager.find(Order.class,id));
    }
}
