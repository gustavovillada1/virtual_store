package co.edu.icesi.virtualstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ItemDTO {

    private UUID itemId;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private double price;

    private String url;
}