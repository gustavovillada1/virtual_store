package co.edu.icesi.virtualstore.repository;

import co.edu.icesi.virtualstore.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {
}
