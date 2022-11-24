package co.edu.icesi.virtualstore.error.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StoreDemoError {
    private String code;
    private String message;
}
