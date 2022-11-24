package co.edu.icesi.virtualstore.repository;

import co.edu.icesi.virtualstore.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;



@Repository
public interface RoleRepository extends CrudRepository<Item, UUID> {

}
