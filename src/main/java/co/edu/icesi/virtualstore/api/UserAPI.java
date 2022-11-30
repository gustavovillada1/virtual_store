package co.edu.icesi.virtualstore.api;

import co.edu.icesi.virtualstore.dto.ItemDTO;
import co.edu.icesi.virtualstore.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/users")
public interface UserAPI {

    @GetMapping("/search/{userId}")
    public UserDTO getUser(@PathVariable UUID userId);


    @PostMapping("/create")
    public UserDTO createUser(@RequestBody @Valid UserDTO userDTO);

    @GetMapping()
    public List<UserDTO> getUsers();

}
