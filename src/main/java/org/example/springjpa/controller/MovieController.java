package org.example.springjpa.controller;

import lombok.RequiredArgsConstructor;
import org.example.springjpa.model.Movie;
import org.example.springjpa.repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    @GetMapping("/between")
    public List<Movie> findAllByReleaseYearBetween(@RequestParam int firstYear,
                                                   @RequestParam int secondYear) {
        return movieRepository.findAllByReleaseYearBetween(firstYear, secondYear);
    }

    @GetMapping("/byReleaseYear")
    public List<Movie> findAllByReleaseYear(@RequestParam int year) {
        return movieRepository.findAllByReleaseYear(year);
    }

    @GetMapping("/byRating")
    public List<Movie> findAllByRatingGreaterThan(@RequestParam double rating) {
        return movieRepository.findAllByRatingGreaterThan(rating);
    }

    @GetMapping("/byTitle")
    public List<Movie> findAllByTitle(@RequestParam String title) {
        return movieRepository.findAllByTitleContainingIgnoreCase(title);
    }

    @GetMapping("/byReleaseYearAndRatingBetween")
    public List<Movie> findAllByReleaseYearInAndRatingBetween(@RequestParam List<Integer> years,
                                                              @RequestParam double firstRating, @RequestParam double secondRating) {
        return movieRepository.findAllByReleaseYearInAndRatingBetween(years, firstRating, secondRating);
    }

    @GetMapping("/byReleaseYearAndRatingGreaterThanAndTitleContaining")
    public List<Movie> findAllByReleaseYearAndRatingGreaterThanAndTitleContainingIgnoreCaseOrderByRatingDesc(
            @RequestParam int releaseYear, @RequestParam double rating, @RequestParam String title
    ) {
        return movieRepository.findAllByReleaseYearAndRatingGreaterThanAndTitleContainingIgnoreCaseOrderByRatingDesc(
                releaseYear, rating, title
        );
    }

    @GetMapping("/top10ByTitleStartingWithAndReleaseYearBetween")
    public List<Movie> findTop10ByTitleStartingWithAndReleaseYearBetween(
            @RequestParam String prefix, @RequestParam int startYear, @RequestParam int endYear
    ) {
        return movieRepository.findTop10ByTitleStartingWithAndReleaseYearBetweenOrderByReleaseYearAsc(
                prefix, startYear, endYear
        );
    }

    @GetMapping("/byTitleLengthAndReleaseYearGreaterThan")
    public List<Movie> findAllByTitleLengthAndReleaseYearGreaterThan(
            @RequestParam int titleLength, @RequestParam int releaseYear
    ) {
        return movieRepository.findAllByTitleLengthAndReleaseYearGreaterThan(titleLength, releaseYear);
    }
}
