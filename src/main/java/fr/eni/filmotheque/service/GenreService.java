package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAllGenres();
    Genre getGenreById(int id);
}
