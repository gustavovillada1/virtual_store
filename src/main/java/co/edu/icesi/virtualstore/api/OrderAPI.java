package co.edu.icesi.virtualstore.api;

import co.edu.icesi.virtualstore.constans.OrderStatus;
import co.edu.icesi.virtualstore.dto.OrderDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/orders")
public interface OrderAPI {

    @PostMapping("/create")
    public OrderDTO createOrder(@RequestBody @Valid OrderDTO orderDTO);

    @GetMapping("/{orderId}")
    public OrderDTO getOrder(@PathVariable UUID orderId);

    @GetMapping()
    public List<OrderDTO> getOrders();

    @PatchMapping("/update/status/{orderId}")
    public OrderDTO updateOrderStatus(@PathVariable @RequestBody UUID orderId, @RequestBody OrderStatus orderStatus);

//    public OrderItemDTO TODO


}
