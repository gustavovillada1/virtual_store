package co.edu.icesi.virtualstore.service.impl;

import co.edu.icesi.virtualstore.controller.RoleController;
import co.edu.icesi.virtualstore.model.Role;
import co.edu.icesi.virtualstore.repository.RoleRepository;
import co.edu.icesi.virtualstore.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    public final RoleRepository roleRepository;

    @Override
    public Role getRole(UUID roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getRoles() {
        return StreamSupport.stream(roleRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
