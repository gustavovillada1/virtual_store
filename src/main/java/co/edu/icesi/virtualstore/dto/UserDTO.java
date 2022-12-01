package co.edu.icesi.virtualstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UserDTO {

    private UUID id;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;

    private String roleId;

}
