package br.com.animelist.error;

import br.com.animelist.error.CustomError;
import br.com.animelist.error.CustomExceptionHandler;
import br.com.animelist.exception.AnimeNotFoundException;
import br.com.animelist.exception.ValidationException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomExceptionHandlerTest {

    @Test
    public void handleAnimeNotFoundException_WithValidException_ReturnsErrorResponse() {
        // Arrange
        AnimeNotFoundException exception = new AnimeNotFoundException(1L);
        HttpStatus expectedStatus = HttpStatus.NOT_FOUND;
        String expectedMessage = "Anime not found with ID: 1";

        CustomExceptionHandler exceptionHandler = new CustomExceptionHandler();

        // Act
        ResponseEntity<Object> responseEntity = exceptionHandler.handleAnimeNotFoundException(exception);
        CustomError customError = (CustomError) responseEntity.getBody();

        // Assert
        assertEquals(expectedStatus, responseEntity.getStatusCode());
        assertEquals(expectedStatus, customError.getStatus());
        assertEquals(expectedMessage, customError.getMessage());
    }

}
