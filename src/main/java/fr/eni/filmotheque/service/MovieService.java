package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.bo.Movie;
import fr.eni.filmotheque.bo.Participant;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();
    Optional<Movie> getMovieById(long id);
    List<Genre> getGenres();
    List<Participant> getParticipants();
    Genre getGenreById(long id);
    Participant getParticipantsById(long id);
    void saveMovie(Movie movie);
}
