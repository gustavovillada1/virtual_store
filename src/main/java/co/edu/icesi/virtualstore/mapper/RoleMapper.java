package co.edu.icesi.virtualstore.mapper;

import co.edu.icesi.virtualstore.dto.RoleDTO;
import co.edu.icesi.virtualstore.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role fromDTO(RoleDTO roleDTO);
    RoleDTO fromRole(Role role);

}
