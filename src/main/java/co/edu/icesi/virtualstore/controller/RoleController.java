package co.edu.icesi.virtualstore.controller;

import co.edu.icesi.virtualstore.api.RoleAPI;
import co.edu.icesi.virtualstore.dto.RoleDTO;
import co.edu.icesi.virtualstore.mapper.RoleMapper;
import co.edu.icesi.virtualstore.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@CrossOrigin
public class RoleController implements RoleAPI {

    public final RoleService roleService;

    public final RoleMapper roleMapper;

    @Override
    public RoleDTO getRole(UUID roleId) {
        return roleMapper.fromRole(roleService.getRole(roleId));
    }

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        return roleMapper.fromRole(roleService.createRole(roleMapper.fromDTO(roleDTO)));
    }

    @Override
    public List<RoleDTO> getRoles() {
        return roleService.getRoles().stream().map(roleMapper::fromRole).collect(Collectors.toList());
    }
}
