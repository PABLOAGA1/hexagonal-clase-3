package com.example.clase3.adapters.in.web;

import com.example.clase3.application.ports.in.OrderUseCase;
import com.example.clase3.application.service.OrderService;
import com.example.clase3.domain.model.Order;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderController {

    @Inject
    private final OrderUseCase orderUseCase;

    @Inject
    public OrderController(OrderUseCase orderUseCase) {
        this.orderUseCase = orderUseCase;
    }

    @GET
    public List<Order> getAllOrders() {
        return orderUseCase.findAll();
    }

    @POST
    public Response create(Order order) {
        Order orderCreate = orderUseCase.save(order);
        return Response.status(Response.Status.CREATED).entity(orderCreate).build();
    }


    @GET
    @Path("/{id}")
    public Response getOrder(@PathParam("id") Long idOrder) {
        Optional<Order> order = orderUseCase.findById(idOrder);
        return order.map(value -> Response.ok(value).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());

    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long idOrder) {
        orderUseCase.deleteById(idOrder);
      return Response.noContent().build();

    }

}


