package co.edu.icesi.virtualstore.error;


import co.edu.icesi.virtualstore.error.exception.StoreDemoError;
import co.edu.icesi.virtualstore.error.exception.StoreDemoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StoreDemoError> handleException(StoreDemoException userDemoException){
        return new ResponseEntity<>(userDemoException.getError(),userDemoException.getHttpStatus());
    }
}
