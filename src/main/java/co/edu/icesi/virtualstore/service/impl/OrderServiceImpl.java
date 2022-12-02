package co.edu.icesi.virtualstore.service.impl;

import co.edu.icesi.virtualstore.constans.OrderStatus;
import co.edu.icesi.virtualstore.error.exception.StoreDemoError;
import co.edu.icesi.virtualstore.error.exception.StoreDemoException;
import co.edu.icesi.virtualstore.model.Order;
import co.edu.icesi.virtualstore.model.OrderItem;
import co.edu.icesi.virtualstore.repository.ItemRepository;
import co.edu.icesi.virtualstore.repository.OrderItemRepository;
import co.edu.icesi.virtualstore.repository.OrderRepository;
import co.edu.icesi.virtualstore.repository.UserRepository;
import co.edu.icesi.virtualstore.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static co.edu.icesi.virtualstore.constans.StoreErrorCode.*;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public Order createOrder(Order order) {
        verifyUserExistence(order.getUserId());
        Order savedOrder = orderRepository.save(order);
        updateOrderItems(savedOrder, order.getOrderItems());
        calculateTotal(order);
        return savedOrder;
    }

    @Override
    public Order getOrder(UUID orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public List<Order> getOrders() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Order updateOrderStatus(UUID orderId, Order updatedOrder) {
        Order oldOrder  = verifyOrderInDatabase(orderId);
        oldOrder.setStatus(updatedOrder.getStatus());
        return orderRepository.save(oldOrder);
    }

    private Order verifyOrderInDatabase(UUID orderId){
        Order order = orderRepository.findById(orderId).orElse(null);
        if(order == null){
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(O_S_01, O_S_01.getErrorMessage()));
        }
        return order;
    }

    private void verifyUserExistence(UUID userId) {
        if(userRepository.findById(userId).isPresent()){
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(O_S_02, O_S_02.getErrorMessage()));
        }
    }

    private void updateOrderItems(Order order, List<OrderItem> orderItems){
        for(OrderItem orderItem: orderItems){
            orderItem.getOrder().setOrderId(order.getOrderId());
            orderItem.setOrder(order);
            orderItem.setItem(itemRepository.findById(orderItem.getItem().getItemId()).get());
            orderItemRepository.save(orderItem);
        }
    }

    private void calculateTotal(Order order){
        double total = 0;
        Optional<List<OrderItem>> orderItems = orderItemRepository.findAllOrderItems(order.getOrderId());
        if(orderItems.isPresent() && orderItems.get().isEmpty() == false){
            for(OrderItem orderItem: orderItems.get()){
                total += orderItem.getQuantity() * orderItem.getItem().getPrice();
            }
        }
        order.setTotal(total);
    }

}
