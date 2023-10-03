package br.com.animelist.repository;

import br.com.animelist.models.AnimeList;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AnimeListRepository extends JpaRepository<AnimeList, Long> {
    boolean existsByName(String name);

    @ApiOperation(value = "Obter todos os animes ordenados por data de lançamento ascendente")
    List<AnimeList> findAllByOrderByReleaseDateAsc();

    @ApiOperation(value = "Encontrar animes por nome")
    List<AnimeList> findByName(
            @ApiParam(value = "Nome do anime", required = true)
            String name);

    @ApiOperation(value = "Encontrar animes por gênero")
    List<AnimeList> findByGenre(
            @ApiParam(value = "Gênero do anime", required = true)
            String genre);

    @ApiOperation(value = "Encontrar animes por estúdio")
    List<AnimeList> findByStudio(
            @ApiParam(value = "Estúdio do anime", required = true)
            String studio);

    @ApiOperation(value = "Encontrar animes por data de lançamento")
    List<AnimeList> findByReleaseDate(
            @ApiParam(value = "Data de lançamento do anime", required = true)
            String releaseDate);
}
