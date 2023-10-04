package br.com.animelist.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnimeNotFoundException extends RuntimeException {
    public AnimeNotFoundException(Long id) {
        super("Anime not found with ID: " + id);
    }
}
