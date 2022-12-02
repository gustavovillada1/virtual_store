package co.edu.icesi.virtualstore.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PermissionDTO {

    private UUID permissionId;

    private String uri;

    private String method;
}
