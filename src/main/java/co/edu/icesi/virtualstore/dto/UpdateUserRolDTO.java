package co.edu.icesi.virtualstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UpdateUserRolDTO {

    private UUID userId;

    private UUID roleId;
}
