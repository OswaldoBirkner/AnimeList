package br.com.animelist.controller;

import br.com.animelist.exception.AnimeNotFoundException;
import br.com.animelist.models.AnimeList;
import br.com.animelist.service.AnimeListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "AnimeList", description = "Endpoints relacionados a lista de animes") // customizando UI do Swagger
@Server(url = "http://localhost:8080", description = "Servidor local de desenvolvimento")
@Server(url = "https://animelist-production.up.railway.app", description = "Servidor de produção")
@RestController
@RequestMapping("/anime")
public class AnimeListController {
    private final AnimeListService animeListService;


    @Autowired
    public AnimeListController(AnimeListService animeListService) {
        this.animeListService = animeListService;
    }

    @Operation(description = "Lista os animes por data de lançamento", method = "GET")// customizando UI do Swagger
    @GetMapping("/all")
    public List<AnimeList> getAllAnimeSortedByReleaseDate() {
        return animeListService.findAllSortedByReleaseDate();
    }

    @Operation(description = "Adiciona um anime", method = "POST")// customizando UI do Swagger
    @PostMapping("/add")
    public AnimeList addAnime(@Valid @RequestBody AnimeList animeList) {
        if(animeListService.existByAnime(animeList.getClass().getName())){
            throw new DataIntegrityViolationException("teste");
        }
        return animeListService.addAnime(animeList);
    }
    @Operation(description = "Deleta um anime por id", method = "DELETE")// customizando UI do Swagger
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAnimeByID(@PathVariable Long id) {
        boolean deleted = animeListService.deleteAnimeByID(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(description = "Faz um update dos dados de um anime pelo id", method = "PUT")// customizando UI do Swagger
    @PutMapping("/update/{id}")
    public ResponseEntity<AnimeList> updateAnimeByID(
            @PathVariable Long id,
            @RequestBody AnimeList animeList
    ) {
        AnimeList updatedAnime = animeListService.updateAnimeByID(id, animeList);
        if (updatedAnime == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedAnime);
    }
    @Operation(description = "Busca o anime pelo id", method = "GET")// customizando UI do Swagger
    @GetMapping("/{id}")
    public ResponseEntity<AnimeList> findAnimeByID(@PathVariable Long id) {
        AnimeList animeList = animeListService.findAnimeByID(id);
        if (animeList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(animeList);
    }
    @Operation(description = "Busca o anime pelo nome", method = "GET")// customizando UI do Swagger
    @GetMapping("/name/{name}")
    public List<AnimeList> findAnimeByName(@PathVariable String name) {
        return animeListService.findAnimeByName(name);
        }

    @Operation(description = "Busca o anime pelo gênero", method = "GET")// customizando UI do Swagger
    @GetMapping("/genre/{genre}")
    public List<AnimeList> findAnimeByGenre(
            @PathVariable String genre
    ) {
        return animeListService.findAnimeByGenre(genre);
    }
    @Operation(description = "Busca o anime pelo estúdio que o desenvolveu", method = "GET")// customizando UI do Swagger
    @GetMapping("/studio/{studio}")
    public List<AnimeList> findAnimeByStudio(
            @PathVariable String studio
    ) {
        return animeListService.findAnimeByStudio(studio);
    }

    @Operation(description = "Busca o anime pela sua data de lançamento", method = "GET")// customizando UI do Swagger
    @GetMapping("/releaseDate/{releaseDate}")
    public List<AnimeList> findAnimeByReleaseDate(
            @PathVariable String releaseDate
    ) {
        return animeListService.findAnimeByReleaseDate(releaseDate);
    }

    @ExceptionHandler(AnimeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleAnimeNotFoundException(AnimeNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleValidationException(org.springframework.web.bind.MethodArgumentNotValidException ex) {
        return new ResponseEntity<>("Erro de validação: " + ex.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }
}
