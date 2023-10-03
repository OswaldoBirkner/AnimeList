package br.com.animelist.exception;

import br.com.animelist.error.CustomError;
import br.com.animelist.exception.ValidationException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationExceptionTest {

    @Test
    public void testValidationException() {
        // Arrange
        String message = "Erro de validação: Campo 'nome' é obrigatório.";

        // Act
        ValidationException ex = new ValidationException(message);

        // Assert
        assertEquals(message, ex.getMessage());
    }
}
