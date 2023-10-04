package br.com.animelist.service;

import br.com.animelist.exception.AnimeNotFoundException;
import br.com.animelist.models.AnimeList;
import br.com.animelist.repository.AnimeListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeListService {
    private final AnimeListRepository animeListRepository;

    @Autowired
    public AnimeListService(AnimeListRepository animeListRepository) {
        this.animeListRepository = animeListRepository;
    }

    public List<AnimeList> findAllSortedByReleaseDate() {
        return animeListRepository.findAllByOrderByReleaseDateAsc();
    }

    public AnimeList addAnime(
            AnimeList animeList) {
        return animeListRepository.save(animeList);
    }

    public boolean deleteAnimeByID(
            Long id) {
        animeListRepository.deleteById(id);
        return false;
    }

    public AnimeList updateAnimeByID(
            Long id,
            AnimeList animeList) {
        Optional<AnimeList> optionalAnime = animeListRepository.findById(id);

        if (optionalAnime.isPresent()) {
            AnimeList existingAnime = optionalAnime.get();

            // Atualize os campos relevantes de acordo com suas necessidades
            existingAnime.setName(animeList.getName());
            existingAnime.setGenre(animeList.getGenre());
            existingAnime.setDescription(animeList.getDescription());
            existingAnime.setStudio(animeList.getStudio());
            existingAnime.setReleaseDate(animeList.getReleaseDate());

            return animeListRepository.save(existingAnime);
        } else {
            throw new AnimeNotFoundException(id);
        }
    }

    public AnimeList findAnimeByID(
            Long id) {
        Optional<AnimeList> optionalAnime = animeListRepository.findById(id);
        return optionalAnime.orElse(null);
    }

    public List<AnimeList> findAnimeByName(
            String name) {
        return animeListRepository.findByName(name);
    }

    public List<AnimeList> findAnimeByGenre(
            String genre) {
        return animeListRepository.findByGenre(genre);
    }

    public List<AnimeList> findAnimeByStudio(
            String studio) {
        return animeListRepository.findByStudio(studio);
    }

    public List<AnimeList> findAnimeByReleaseDate(
            String releaseDate) {
        return animeListRepository.findByReleaseDate(releaseDate);
    }

    public boolean existByAnime(String anime) {
        return animeListRepository.existsByName(anime);
    }
}
