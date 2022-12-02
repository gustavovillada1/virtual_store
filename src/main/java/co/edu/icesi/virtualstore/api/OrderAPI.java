package co.edu.icesi.virtualstore.api;

import co.edu.icesi.virtualstore.constans.OrderStatus;
import co.edu.icesi.virtualstore.dto.OrderDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/orders")
public interface OrderAPI {

    @PostMapping("/create")
    public OrderDTO createOrder(@RequestBody @Valid OrderDTO orderDTO);

    @PutMapping("/update/{orderId}")
    public OrderDTO updateOrderStatus(@PathVariable UUID orderId, @RequestBody OrderStatus orderStatus);


}
