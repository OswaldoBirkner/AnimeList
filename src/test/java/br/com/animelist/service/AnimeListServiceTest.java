package br.com.animelist.service;

import br.com.animelist.exception.AnimeNotFoundException;
import br.com.animelist.models.AnimeList;
import br.com.animelist.repository.AnimeListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AnimeListServiceTest {

    @InjectMocks
    private AnimeListService animeListService;

    @Mock
    private AnimeListRepository animeListRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAllSortedByReleaseDate() {
        // Mock data
        AnimeList anime1 = new AnimeList();
        AnimeList anime2 = new AnimeList();
        List<AnimeList> animeList = Arrays.asList(anime1, anime2);

        when(animeListRepository.findAllByOrderByReleaseDateAsc()).thenReturn(animeList);

        List<AnimeList> result = animeListService.findAllSortedByReleaseDate();

        assertEquals(2, result.size());
    }

    @Test
    void testAddAnime() {
        AnimeList anime = new AnimeList();

        when(animeListRepository.save(anime)).thenReturn(anime);

        AnimeList result = animeListService.addAnime(anime);

        assertNotNull(result);
    }

    @Test
    void testDeleteAnimeByID() {
        Long id = 1L;

        animeListService.deleteAnimeByID(id);

        verify(animeListRepository, times(1)).deleteById(id);
    }

    @Test
    void testUpdateAnimeByID() {
        Long id = 1L;
        AnimeList existingAnime = new AnimeList();
        existingAnime.setId(id);

        AnimeList updatedAnime = new AnimeList();
        updatedAnime.setId(id);

        when(animeListRepository.findById(id)).thenReturn(Optional.of(existingAnime));
        when(animeListRepository.save(existingAnime)).thenReturn(updatedAnime);

        AnimeList result = animeListService.updateAnimeByID(id, updatedAnime);

        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    void testUpdateAnimeByIDAnimeNotFound() {
        Long id = 1L;
        AnimeList updatedAnime = new AnimeList();

        when(animeListRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(AnimeNotFoundException.class, () -> animeListService.updateAnimeByID(id, updatedAnime));
    }

    @Test
    void testFindAnimeByID() {
        Long id = 1L;
        AnimeList anime = new AnimeList();
        anime.setId(id);

        when(animeListRepository.findById(id)).thenReturn(Optional.of(anime));

        AnimeList result = animeListService.findAnimeByID(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    void testFindAnimeByIDAnimeNotFound() {
        Long id = 1L;

        when(animeListRepository.findById(id)).thenReturn(Optional.empty());

        AnimeList result = animeListService.findAnimeByID(id);

        assertNull(result);
    }

    @Test
    void testFindAnimeByName() {
        String name = "My Anime";
        AnimeList anime1 = new AnimeList();
        AnimeList anime2 = new AnimeList();
        List<AnimeList> animeList = Arrays.asList(anime1, anime2);

        when(animeListRepository.findByName(name)).thenReturn(animeList);

        List<AnimeList> result = animeListService.findAnimeByName(name);

        assertEquals(2, result.size());
    }

    @Test
    void testFindAnimeByGenre() {
        String genre = "Action";
        AnimeList anime1 = new AnimeList();
        AnimeList anime2 = new AnimeList();
        List<AnimeList> animeList = Arrays.asList(anime1, anime2);

        when(animeListRepository.findByGenre(genre)).thenReturn(animeList);

        List<AnimeList> result = animeListService.findAnimeByGenre(genre);

        assertEquals(2, result.size());
    }

    @Test
    void testFindAnimeByStudio() {
        String studio = "Studio A";
        AnimeList anime1 = new AnimeList();
        AnimeList anime2 = new AnimeList();
        List<AnimeList> animeList = Arrays.asList(anime1, anime2);

        when(animeListRepository.findByStudio(studio)).thenReturn(animeList);

        List<AnimeList> result = animeListService.findAnimeByStudio(studio);

        assertEquals(2, result.size());
    }

    @Test
    void testFindAnimeByReleaseDate() {
        String releaseDate = "";
        AnimeList anime1 = new AnimeList();
        AnimeList anime2 = new AnimeList();
        List<AnimeList> animeList = Arrays.asList(anime1, anime2);

        when(animeListRepository.findByReleaseDate(releaseDate)).thenReturn(animeList);

        List<AnimeList> result = animeListService.findAnimeByReleaseDate(releaseDate);

        assertEquals(2, result.size());
    }

    @Test
    public void testExistByAnime_Exists() {
        // Defina um nome de anime que deve existir no repositório
        String animeName = "Naruto";

        // Quando o método existsByName do AnimeListRepository for chamado com o nome do anime,
        // retorne true (indicando que o anime existe no repositório)
        when(animeListRepository.existsByName(animeName)).thenReturn(true);

        // Execute o método existByAnime
        boolean result = animeListService.existByAnime(animeName);

        // Verifique se o resultado é verdadeiro (o anime existe)
        assertTrue(result);
    }

    @Test
    public void testExistByAnime_NotExists() {
        // Defina um nome de anime que não deve existir no repositório
        String animeName = "One Piece";

        // Quando o método existsByName do AnimeListRepository for chamado com o nome do anime,
        // retorne false (indicando que o anime não existe no repositório)
        when(animeListRepository.existsByName(animeName)).thenReturn(false);

        // Execute o método existByAnime
        boolean result = animeListService.existByAnime(animeName);

        // Verifique se o resultado é falso (o anime não existe)
        assertFalse(result);
    }

}
