package co.edu.icesi.virtualstore.repository;

import co.edu.icesi.virtualstore.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;



@Repository
public interface RoleRepository extends CrudRepository<Role, UUID> {

    @Override
    Optional<Role> findById(UUID id);
}
