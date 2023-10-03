package br.com.animelist.error;

import br.com.animelist.error.CustomError;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomErrorTest {

    @Test
    public void createCustomError_WithValidValues_ReturnsCorrectValues() {
        // Arrange
        HttpStatus expectedStatus = HttpStatus.BAD_REQUEST;
        String expectedMessage = "Ocorreu um erro ao processar a solicitação.";
        LocalDateTime expectedTimestamp = LocalDateTime.of(2023, 9, 23, 10, 15, 30);

        // Act
        CustomError customError = new CustomError(expectedStatus, expectedMessage, expectedTimestamp);

        // Assert
        assertEquals(expectedStatus, customError.getStatus());
        assertEquals(expectedMessage, customError.getMessage());
        assertEquals(expectedTimestamp, customError.getTimestamp());
    }

    @Test
    public void createCustomError_WithDifferentValues_ReturnsDifferentValues() {
        // Arrange
        HttpStatus expectedStatus = HttpStatus.NOT_FOUND;
        String expectedMessage = "Recurso não encontrado.";
        LocalDateTime expectedTimestamp = LocalDateTime.of(2023, 9, 24, 12, 0, 0);

        // Act
        CustomError customError = new CustomError(expectedStatus, expectedMessage, expectedTimestamp);

        // Assert
        assertEquals(expectedStatus, customError.getStatus());
        assertEquals(expectedMessage, customError.getMessage());
        assertEquals(expectedTimestamp, customError.getTimestamp());
    }
}
