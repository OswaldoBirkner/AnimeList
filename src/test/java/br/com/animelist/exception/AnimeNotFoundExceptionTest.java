package br.com.animelist.exception;

import br.com.animelist.error.CustomError;
import br.com.animelist.exception.AnimeNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimeNotFoundExceptionTest {

    @Test
    public void testAnimeNotFoundException() {
        // Arrange
        Long id = 1L;

        // Act
        AnimeNotFoundException ex = new AnimeNotFoundException(id);

        // Assert
        assertEquals("Anime not found with ID: " + id, ex.getMessage());
    }
}
