package br.com.animelist.exception;

import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(tags = "Anime Not Found Exception", description = "Exceção para anime não encontrado")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnimeNotFoundException extends RuntimeException {
    public AnimeNotFoundException(Long id) {
        super("Anime not found with ID: " + id);
    }
}
