package co.edu.icesi.virtualstore.dto;

import co.edu.icesi.virtualstore.constans.OrderStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDTO {

    private UUID orderId;

    @NotNull
    private double total;

    @NotNull
    private String status;

    private List<OrderItemDTO> orderItems;

    @NotNull
    private UUID userId;

}
