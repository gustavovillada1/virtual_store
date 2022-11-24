package co.edu.icesi.virtualstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ItemDTO {

    private UUID itemId;

    private String name;

    private String description;

    private double price;


}
