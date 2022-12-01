package co.edu.icesi.virtualstore.service;

import co.edu.icesi.virtualstore.model.Role;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface RoleService {

    public Role getRole(@PathVariable UUID roleId);
    public Role createRole(@RequestBody Role role);
    public List<Role> getRoles();
}
