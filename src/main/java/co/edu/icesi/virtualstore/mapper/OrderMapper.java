package co.edu.icesi.virtualstore.mapper;

import co.edu.icesi.virtualstore.dto.OrderDTO;
import co.edu.icesi.virtualstore.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order fromDTO(OrderDTO orderDTO);
    OrderDTO fromOrder(Order order);

}