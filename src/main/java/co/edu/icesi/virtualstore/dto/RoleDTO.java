package co.edu.icesi.virtualstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Data
public class RoleDTO {

    private UUID id;

    private String name;

    private String description;

    private List<PermissionDTO> rolePermissions;
}
