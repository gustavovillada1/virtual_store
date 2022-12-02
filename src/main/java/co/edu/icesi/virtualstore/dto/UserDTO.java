package co.edu.icesi.virtualstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UserDTO {

    private UUID id;

    @NotNull
    private String email;

    @NotNull
    private String password;

    private String address;

    private String phone;

    private String roleName;
}
