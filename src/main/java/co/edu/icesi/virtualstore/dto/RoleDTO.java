package co.edu.icesi.virtualstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class RoleDTO {

    private UUID id;
    private String name;
    private String description;

}
