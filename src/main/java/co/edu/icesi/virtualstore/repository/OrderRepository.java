package co.edu.icesi.virtualstore.repository;

import co.edu.icesi.virtualstore.model.Item;
import co.edu.icesi.virtualstore.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends CrudRepository<Order, UUID> {

    @Query(value = "SELECT * FROM orders WHERE orders.user_id = ?1", nativeQuery = true)
    Optional<List<Order>> findOrdersFromUser(UUID userId);
}
