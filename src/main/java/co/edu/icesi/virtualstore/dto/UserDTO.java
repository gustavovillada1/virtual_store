package co.edu.icesi.virtualstore.dto;

import co.edu.icesi.virtualstore.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UserDTO {

    private UUID userId;

    @NotNull
    private String email;

    @NotNull
    private String password;

    private String address;

    private String phone;

    private Role role;
}
