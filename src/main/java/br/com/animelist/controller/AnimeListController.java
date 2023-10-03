package br.com.animelist.controller;

import br.com.animelist.exception.AnimeNotFoundException;
import br.com.animelist.models.AnimeList;
import br.com.animelist.service.AnimeListService;
import io.swagger.annotations.*;
import jakarta.validation.Valid;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/anime")
@Api(tags = "Anime List", description = "API para gerenciar informações de animes")
public class AnimeListController {
    private final AnimeListService animeListService;

    @Autowired
    public AnimeListController(AnimeListService animeListService) {
        this.animeListService = animeListService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Obter todos os animes ordenados por data de lançamento")
    public List<AnimeList> getAllAnimeSortedByReleaseDate() {
        return animeListService.findAllSortedByReleaseDate();
    }

    @PostMapping("/add")
    @ApiOperation(value = "Adicionar um novo anime")
    public AnimeList addAnime(@Valid @RequestBody AnimeList animeList) {
        if(animeListService.existByAnime(animeList.getClass().getName())){
            throw new DataIntegrityViolationException("teste");
        }
        return animeListService.addAnime(animeList);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Excluir um anime por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Anime excluído com sucesso"),
            @ApiResponse(code = 404, message = "Anime não encontrado")
    })
    public ResponseEntity<Void> deleteAnimeByID(@PathVariable Long id) {
        boolean deleted = animeListService.deleteAnimeByID(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Atualizar informações de um anime por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Anime atualizado com sucesso"),
            @ApiResponse(code = 404, message = "Anime não encontrado")
    })
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

    @GetMapping("/{id}")
    @ApiOperation(value = "Encontrar um anime por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Anime encontrado com sucesso"),
            @ApiResponse(code = 404, message = "Anime não encontrado")
    })
    public ResponseEntity<AnimeList> findAnimeByID(@PathVariable Long id) {
        AnimeList animeList = animeListService.findAnimeByID(id);
        if (animeList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(animeList);
    }

    @GetMapping("/name/{name}")
    @ApiOperation(value = "Encontrar animes por nome")
    public List<AnimeList> findAnimeByName(

            @PathVariable
            @ApiParam(value = "Nome do anime a ser pesquisado", example = "Naruto") String name) {

        return animeListService.findAnimeByName(name);
        }


    @GetMapping("/genre/{genre}")
    @ApiOperation(value = "Encontrar animes por gênero")
    public List<AnimeList> findAnimeByGenre(
            @PathVariable
            @ApiParam(value = "Gênero do anime a ser pesquisado", example = "Ação") String genre
    ) {
        return animeListService.findAnimeByGenre(genre);
    }

    @GetMapping("/studio/{studio}")
    @ApiOperation(value = "Encontrar animes por estúdio de produção")
    public List<AnimeList> findAnimeByStudio(
            @PathVariable
            @ApiParam(value = "Nome do estúdio de produção a ser pesquisado", example = "Studio Ghibli") String studio
    ) {
        return animeListService.findAnimeByStudio(studio);
    }

    @GetMapping("/releaseDate/{releaseDate}")
    @ApiOperation(value = "Encontrar animes por data de lançamento")
    public List<AnimeList> findAnimeByReleaseDate(
            @PathVariable
            @ApiParam(value = "Data de lançamento a ser pesquisada no formato yyyy-MM-dd", example = "2023-09-23") String releaseDate
    ) {
        return animeListService.findAnimeByReleaseDate(releaseDate);
    }

    @ExceptionHandler(AnimeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ApiOperation(value = "Tratar exceção de anime não encontrado")
    public ResponseEntity<Object> handleAnimeNotFoundException(AnimeNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ApiOperation(value = "Tratar exceção de validação")
    public ResponseEntity<Object> handleValidationException(org.springframework.web.bind.MethodArgumentNotValidException ex) {
        return new ResponseEntity<>("Erro de validação: " + ex.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }
}
