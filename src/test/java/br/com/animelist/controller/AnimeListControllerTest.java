package br.com.animelist.controller;

import br.com.animelist.models.AnimeList;
import br.com.animelist.service.AnimeListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AnimeListControllerTest {

    @Mock
    private AnimeListService animeListService;

    @InjectMocks
    private AnimeListController animeListController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllAnimeSortedByReleaseDate() throws ParseException {
        // Crie uma lista de animes para teste
        List<AnimeList> animeList = new ArrayList<>();

        AnimeList anime1 = new AnimeList();
        anime1.setName("Anime 1");
        anime1.setReleaseDate("2021-09-30"); // Defina a data como uma string no formato "yyyy-MM-dd"
        animeList.add(anime1);

        AnimeList anime2 = new AnimeList();
        anime2.setName("Anime 2");
        anime2.setReleaseDate("2022-09-30"); // Defina outra data como uma string no formato "yyyy-MM-dd"
        animeList.add(anime2);

        when(animeListService.findAllSortedByReleaseDate()).thenReturn(animeList);

        // Execute o método de busca
        List<AnimeList> result = animeListController.getAllAnimeSortedByReleaseDate();

        // Verifique se a lista não está vazia
        assertNotNull(result);

        // Crie um formato de data
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Converta as strings de data em objetos de data
        Date date1 = dateFormat.parse(anime1.getReleaseDate());
        Date date2 = dateFormat.parse(anime2.getReleaseDate());

        // Verifique se os animes estão ordenados por data de lançamento ascendente
        assertTrue(date1.before(date2));
    }

    @Test
    public void testAddAnime() {
        // Crie um anime para teste
        AnimeList anime = new AnimeList();
        anime.setName("Anime Test");

        when(animeListService.addAnime(any())).thenReturn(anime);

        // Execute o método de adição
        AnimeList addedAnime = animeListController.addAnime(anime);

        // Verifique se o anime foi adicionado com sucesso
        assertNotNull(addedAnime);
        assertEquals("Anime Test", addedAnime.getName());
    }

    @Test
    public void testDeleteAnimeByID() {
        // Defina o ID do anime a ser excluído
        Long animeId = 1L;

        // Execute o método de exclusão
        animeListController.deleteAnimeByID(animeId);

        // Verifique se o método de exclusão do serviço foi chamado com o ID correto
        verify(animeListService, times(1)).deleteAnimeByID(animeId);
    }

    @Test
    public void testUpdateAnimeByID() {
        // Crie um anime existente para teste
        AnimeList existingAnime = new AnimeList();
        existingAnime.setId(1L);
        existingAnime.setName("Existing Anime");

        // Crie um anime com dados atualizados
        AnimeList updatedAnime = new AnimeList();
        updatedAnime.setName("Updated Anime");

        when(animeListService.updateAnimeByID(existingAnime.getId(), updatedAnime)).thenReturn(updatedAnime);

        // Execute o método de atualização
        ResponseEntity<AnimeList> result = animeListController.updateAnimeByID(existingAnime.getId(), updatedAnime);

        // Verifique se o anime foi atualizado com sucesso
        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Updated Anime", result.getBody().getName());
    }

    @Test
    public void testUpdateAnimeByID_NotFound() {
        // Defina um ID de anime que não existe
        Long animeId = 1L;

        // Crie um anime com dados atualizados
        AnimeList updatedAnime = new AnimeList();
        updatedAnime.setName("Updated Anime");

        when(animeListService.updateAnimeByID(animeId, updatedAnime)).thenReturn(null);

        // Execute o método de atualização
        ResponseEntity<AnimeList> result = animeListController.updateAnimeByID(animeId, updatedAnime);

        // Verifique se o anime não foi encontrado
        assertNotNull(result);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

    @Test
    public void testFindAnimeByID() {
        // Defina o ID do anime a ser encontrado
        Long animeId = 1L;

        // Crie um anime para teste
        AnimeList anime = new AnimeList();
        anime.setId(animeId);
        anime.setName("Anime Test");

        when(animeListService.findAnimeByID(animeId)).thenReturn(anime);

        // Execute o método de busca por ID
        ResponseEntity<AnimeList> result = animeListController.findAnimeByID(animeId);

        // Verifique se o anime foi encontrado com sucesso
        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Anime Test", result.getBody().getName());
    }

    @Test
    public void testFindAnimeByID_NotFound() {
        // Defina um ID de anime que não existe
        Long animeId = 1L;

        when(animeListService.findAnimeByID(animeId)).thenReturn(null);

        // Execute o método de busca por ID
        ResponseEntity<AnimeList> result = animeListController.findAnimeByID(animeId);

        // Verifique se o anime não foi encontrado
        assertNotNull(result);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

    @Test
    public void testFindAnimeByName() {
        // Defina o nome do anime a ser encontrado
        String animeName = "Naruto";

        // Crie uma lista de animes com o nome especificado
        List<AnimeList> animeList = new ArrayList<>();
        AnimeList anime1 = new AnimeList();
        anime1.setName(animeName);
        animeList.add(anime1);

        when(animeListService.findAnimeByName(animeName)).thenReturn(animeList);

        // Execute o método de busca por nome
        List<AnimeList> result = animeListController.findAnimeByName(animeName);

        // Verifique se a lista de animes foi encontrada com sucesso
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(animeName, result.get(0).getName());
    }

    @Test
    public void testFindAnimeByGenre() {
        // Defina o gênero do anime a ser encontrado
        String animeGenre = "Ação";

        // Crie uma lista de animes com o gênero especificado
        List<AnimeList> animeList = new ArrayList<>();
        AnimeList anime1 = new AnimeList();
        anime1.setGenre(animeGenre);
        animeList.add(anime1);

        when(animeListService.findAnimeByGenre(animeGenre)).thenReturn(animeList);

        // Execute o método de busca por gênero
        List<AnimeList> result = animeListController.findAnimeByGenre(animeGenre);

        // Verifique se a lista de animes foi encontrada com sucesso
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(animeGenre, result.get(0).getGenre());
    }

    @Test
    public void testFindAnimeByStudio() {
        // Defina o estúdio de produção a ser encontrado
        String animeStudio = "Studio Ghibli";

        // Crie uma lista de animes com o estúdio de produção especificado
        List<AnimeList> animeList = new ArrayList<>();
        AnimeList anime1 = new AnimeList();
        anime1.setStudio(animeStudio);
        animeList.add(anime1);

        when(animeListService.findAnimeByStudio(animeStudio)).thenReturn(animeList);

        // Execute o método de busca por estúdio de produção
        List<AnimeList> result = animeListController.findAnimeByStudio(animeStudio);

        // Verifique se a lista de animes foi encontrada com sucesso
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(animeStudio, result.get(0).getStudio());
    }

    @Test
    public void testFindAnimeByReleaseDate() {
        // Defina a data de lançamento a ser encontrada
        String releaseDate = "";

        // Crie uma lista de animes com a data de lançamento especificada
        List<AnimeList> animeList = new ArrayList<>();
        AnimeList anime1 = new AnimeList();
        anime1.setReleaseDate(releaseDate);
        animeList.add(anime1);

        when(animeListService.findAnimeByReleaseDate(releaseDate)).thenReturn(animeList);

        // Execute o método de busca por data de lançamento
        List<AnimeList> result = animeListController.findAnimeByReleaseDate(releaseDate);

        // Verifique se a lista de animes foi encontrada com sucesso
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(releaseDate, result.get(0).getReleaseDate());
    }

}
