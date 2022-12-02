package co.edu.icesi.virtualstore.service;

import co.edu.icesi.virtualstore.constans.OrderStatus;
import co.edu.icesi.virtualstore.model.Order;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface OrderService {

    public Order createOrder(@RequestBody @Valid Order order);

    public Order getOrder(@PathVariable UUID orderId);

    public List<Order> getOrders();

    public Order updateOrderStatus(@PathVariable @RequestBody UUID orderId, @RequestBody OrderStatus orderStatus);

}
