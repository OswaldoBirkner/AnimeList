package br.com.animelist.repository;
import br.com.animelist.models.AnimeList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AnimeListRepository extends JpaRepository<AnimeList, Long> {
    boolean existsByName(String name);

    List<AnimeList> findAllByOrderByReleaseDateAsc();

    List<AnimeList> findByName(
            String name);

    List<AnimeList> findByGenre(
            String genre);

    List<AnimeList> findByStudio(
            String studio);

    List<AnimeList> findByReleaseDate(
            String releaseDate);
}
