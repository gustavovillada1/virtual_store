package co.edu.icesi.virtualstore.repository;

import co.edu.icesi.virtualstore.model.Item;
import co.edu.icesi.virtualstore.model.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, UUID> {
}
