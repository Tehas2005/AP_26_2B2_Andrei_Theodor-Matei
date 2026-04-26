package org.example;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    @Operation(summary = "Obtine toate filmele din DB")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Adauga un film nou (POST)")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifica complet un film existent (PUT)")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        if(!movieRepository.existsById(id)) throw new MovieException(id);
        updatedMovie.setId(id);
        return movieRepository.save(updatedMovie);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Modifica doar scorul unui film (PATCH)")
    public Movie updateMovieScore(@PathVariable Long id, @RequestParam Double score) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieException(id));
        movie.setScore(score);
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Sterge un film (DELETE)")
    public void deleteMovie(@PathVariable Long id) {
        if(!movieRepository.existsById(id)) throw new MovieException(id);
        movieRepository.deleteById(id);
    }
}