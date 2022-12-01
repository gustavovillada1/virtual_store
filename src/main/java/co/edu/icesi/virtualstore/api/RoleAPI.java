package co.edu.icesi.virtualstore.api;

import co.edu.icesi.virtualstore.dto.RoleDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/admin/roles")
public interface RoleAPI {

    @GetMapping("/search/{roleId}")
    public RoleDTO getRole(@PathVariable UUID roleId);

    @PostMapping("/create")
    public RoleDTO createRole(@RequestBody RoleDTO roleDTO);

    @GetMapping
    public List<RoleDTO> getRoles();

}
