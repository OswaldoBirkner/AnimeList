package br.com.animelist.error;
import br.com.animelist.exception.AnimeNotFoundException;
import org.modelmapper.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
@ControllerAdvice
@RestController
public class CustomExceptionHandler {

    @ExceptionHandler(AnimeNotFoundException.class)
    public ResponseEntity<Object> handleAnimeNotFoundException(AnimeNotFoundException ex) {
        CustomError customError = new CustomError(HttpStatus.NOT_FOUND, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(customError, customError.getStatus());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<CustomError> handleValidationException(ValidationException ex) {
        CustomError customError = new CustomError(HttpStatus.BAD_REQUEST, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(customError, customError.getStatus());
    }
}
