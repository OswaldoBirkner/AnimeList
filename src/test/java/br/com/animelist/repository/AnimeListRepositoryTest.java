package br.com.animelist.repository;

import br.com.animelist.models.AnimeList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AnimeListRepositoryTest {

    @Autowired
    private AnimeListRepository animeListRepository;

    @Test
    public void testFindAllByOrderByReleaseDateAsc() {
        List<AnimeList> animeList = animeListRepository.findAllByOrderByReleaseDateAsc();
        assertNotNull(animeList);
    }

    @Test
    public void testFindById() {
        Long animeId = 1L;
        Optional<AnimeList> foundAnime = animeListRepository.findById(animeId);
        assertTrue(foundAnime.isEmpty());
    }

    @Test
    public void testFindByName() {
        List<AnimeList> animeList = animeListRepository.findByName("Naruto");
        assertNotNull(animeList);
    }

    @Test
    public void testFindByGenre() {
        List<AnimeList> animeList = animeListRepository.findByGenre("Ação");
        assertNotNull(animeList);
    }

    @Test
    public void testFindByStudio() {
        List<AnimeList> animeList = animeListRepository.findByStudio("Studio Ghibli");
        assertNotNull(animeList);
    }

    @Test
    public void testFindByReleaseDate() {
        String releaseDate = ""; // Substitua pela data de lançamento desejada
        List<AnimeList> animeList = animeListRepository.findByReleaseDate(releaseDate);
        assertNotNull(animeList);
    }
}
