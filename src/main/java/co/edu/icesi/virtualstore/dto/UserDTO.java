package co.edu.icesi.virtualstore.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDTO {

    private UUID id;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;

}
