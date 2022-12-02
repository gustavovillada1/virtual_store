package co.edu.icesi.virtualstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class OrderItemDTO {

    private UUID orderItemId;
    private int quantity;
    private OrderDTO order;
    private ItemDTO item;
}
