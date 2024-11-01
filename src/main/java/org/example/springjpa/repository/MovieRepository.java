package org.example.springjpa.repository;

import org.example.springjpa.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findAllByReleaseYear(int releaseYear);
    List<Movie> findAllByRatingGreaterThan(double rating);
    List<Movie> findAllByTitleContainingIgnoreCase(String title);
    List<Movie> findAllByReleaseYearBetween(int firstReleaseYear, int secondReleaseYear);
    List<Movie> findAllByReleaseYearInAndRatingBetween(List<Integer> years,
                                                       double firstRating, double secondRating);
    List<Movie> findAllByReleaseYearAndRatingGreaterThanAndTitleContainingIgnoreCaseOrderByRatingDesc(
            int releaseYear, double rating, String title
    );
    List<Movie> findTop10ByTitleStartingWithAndReleaseYearBetweenOrderByReleaseYearAsc(
            String prefix, int startYear, int endYear
    );
    @Query("select m from Movie m where length(m.title) = :titleLength AND m.releaseYear > :releaseYear")
    List<Movie> findAllByTitleLengthAndReleaseYearGreaterThan(@Param("titleLength") int titleLength,
                                                              @Param("releaseYear") int releaseYear);
}
