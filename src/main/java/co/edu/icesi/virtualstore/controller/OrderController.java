package co.edu.icesi.virtualstore.controller;

import co.edu.icesi.virtualstore.api.OrderAPI;
import co.edu.icesi.virtualstore.constans.OrderStatus;
import co.edu.icesi.virtualstore.dto.OrderDTO;
import co.edu.icesi.virtualstore.error.exception.StoreDemoError;
import co.edu.icesi.virtualstore.error.exception.StoreDemoException;
import co.edu.icesi.virtualstore.mapper.OrderMapper;
import co.edu.icesi.virtualstore.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static co.edu.icesi.virtualstore.constans.OrderStatus.*;
import static co.edu.icesi.virtualstore.constans.StoreErrorCode.O_C_01;
import static co.edu.icesi.virtualstore.constans.StoreErrorCode.O_C_02;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController implements OrderAPI {

    private final OrderService orderService;

    private final OrderMapper orderMapper;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        verifyTotalRange(orderDTO.getTotal());
        return orderMapper.fromOrder(orderService.createOrder(orderMapper.fromDTO(orderDTO)));
    }

    @Override
    public OrderDTO getOrder(UUID orderId) {
        return orderMapper.fromOrder(orderService.getOrder(orderId));
    }

    @Override
    public List<OrderDTO> getOrders() {
        return orderService.getOrders().stream().map(orderMapper::fromOrder).collect(Collectors.toList());
    }

    @Override
    public OrderDTO updateOrderStatus(UUID orderId, OrderDTO orderDTO) {
        verifyStatusExistence(orderDTO.getStatus());
        //TODO validate state update difference between user and admin
        return orderMapper.fromOrder(orderService.updateOrderStatus(orderId, orderMapper.fromDTO(orderDTO)));
    }

    private void verifyStatusExistence(OrderStatus orderStatus){
        if(orderStatus.equals(CANCELED) || orderStatus.equals(CART)
                || orderStatus.equals(SENT) || orderStatus.equals(COMPLETED)){

        }else{
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(O_C_01, O_C_01.getErrorMessage()));
        }
    }

    private void verifyTotalRange(double total){
        if(total <= 0){
            throw new StoreDemoException(HttpStatus.BAD_REQUEST, new StoreDemoError(O_C_02, O_C_02.getErrorMessage()));
        }
    }
}
