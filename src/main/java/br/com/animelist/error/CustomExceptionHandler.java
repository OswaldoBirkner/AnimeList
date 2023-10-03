package br.com.animelist.error;

import br.com.animelist.exception.AnimeNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Api(tags = "Custom Exception Handling", description = "Tratamento personalizado de exceções")
@ControllerAdvice
@RestController
public class CustomExceptionHandler {

    @ApiOperation(value = "Tratar exceção AnimeNotFoundException")
    @ExceptionHandler(AnimeNotFoundException.class)
    public ResponseEntity<Object> handleAnimeNotFoundException(AnimeNotFoundException ex) {
        CustomError customError = new CustomError(HttpStatus.NOT_FOUND, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(customError, customError.getStatus());
    }

    @ApiOperation(value = "Tratar exceção ValidationException")
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<CustomError> handleValidationException(ValidationException ex) {
        CustomError customError = new CustomError(HttpStatus.BAD_REQUEST, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(customError, customError.getStatus());
    }
}
