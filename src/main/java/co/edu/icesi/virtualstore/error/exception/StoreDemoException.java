package co.edu.icesi.virtualstore.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class StoreDemoException extends RuntimeException{
    private HttpStatus httpStatus;
    private StoreDemoError error;
}
