package co.edu.icesi.virtualstore.api;

import co.edu.icesi.virtualstore.dto.UpdateUserRolDTO;
import co.edu.icesi.virtualstore.model.Role;
import co.edu.icesi.virtualstore.dto.UserCreateDTO;
import co.edu.icesi.virtualstore.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/users")
public interface UserAPI {

    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable UUID userId);


    @PostMapping()
    public UserDTO createUser(@RequestBody UserCreateDTO userCreateDTO);

    @PatchMapping("/{userId}")
    public UserDTO updateUserRol(@PathVariable UUID userId, @RequestBody UpdateUserRolDTO newRoleId);

    @GetMapping()
    public List<UserDTO> getUsers();

}
