package co.edu.icesi.virtualstore.repository;

import co.edu.icesi.virtualstore.model.Item;
import co.edu.icesi.virtualstore.model.OrderItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, UUID> {

    @Query(value = "SELECT * FROM order_item WHERE order_item.order_id = ?1", nativeQuery = true)
    Optional<List<OrderItem>> findAllOrderItems(UUID orderId);

}
