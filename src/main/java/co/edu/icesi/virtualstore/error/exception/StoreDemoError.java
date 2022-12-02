package co.edu.icesi.virtualstore.error.exception;

import co.edu.icesi.virtualstore.utils.constans.StoreErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StoreDemoError {
    private StoreErrorCode code;
    private String message;
}
