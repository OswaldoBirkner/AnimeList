package br.com.animelist.service;

import br.com.animelist.exception.AnimeNotFoundException;
import br.com.animelist.models.AnimeList;
import br.com.animelist.repository.AnimeListRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @ApiOperation(value = "Obter todos os animes ordenados por data de lançamento ascendente")
    public List<AnimeList> findAllSortedByReleaseDate() {
        return animeListRepository.findAllByOrderByReleaseDateAsc();
    }

    @ApiOperation(value = "Adicionar um novo anime")
    public AnimeList addAnime(
            @ApiParam(value = "Detalhes do anime a ser adicionado", required = true)
            AnimeList animeList) {
        return animeListRepository.save(animeList);
    }

    @ApiOperation(value = "Excluir um anime por ID")
    public boolean deleteAnimeByID(
            @ApiParam(value = "ID único do anime a ser excluído", required = true)
            Long id) {
        animeListRepository.deleteById(id);
        return false;
    }

    @ApiOperation(value = "Atualizar um anime por ID")
    public AnimeList updateAnimeByID(
            @ApiParam(value = "ID único do anime a ser atualizado", required = true)
            Long id,
            @ApiParam(value = "Detalhes do anime atualizado", required = true)
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

    @ApiOperation(value = "Encontrar um anime por ID")
    public AnimeList findAnimeByID(
            @ApiParam(value = "ID único do anime a ser encontrado", required = true)
            Long id) {
        Optional<AnimeList> optionalAnime = animeListRepository.findById(id);
        return optionalAnime.orElse(null);
    }

    @ApiOperation(value = "Encontrar animes por nome")
    public List<AnimeList> findAnimeByName(
            @ApiParam(value = "Nome do anime a ser encontrado", required = true)
            String name) {
        return animeListRepository.findByName(name);
    }

    @ApiOperation(value = "Encontrar animes por gênero")
    public List<AnimeList> findAnimeByGenre(
            @ApiParam(value = "Gênero do anime a ser encontrado", required = true)
            String genre) {
        return animeListRepository.findByGenre(genre);
    }

    @ApiOperation(value = "Encontrar animes por estúdio")
    public List<AnimeList> findAnimeByStudio(
            @ApiParam(value = "Estúdio do anime a ser encontrado", required = true)
            String studio) {
        return animeListRepository.findByStudio(studio);
    }

    @ApiOperation(value = "Encontrar animes por data de lançamento")
    public List<AnimeList> findAnimeByReleaseDate(
            @ApiParam(value = "Data de lançamento do anime a ser encontrado", required = true)
            String releaseDate) {
        return animeListRepository.findByReleaseDate(releaseDate);
    }

    public boolean existByAnime(String anime) {
        return animeListRepository.existsByName(anime);
    }
}
