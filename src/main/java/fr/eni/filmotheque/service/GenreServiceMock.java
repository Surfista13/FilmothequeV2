package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Genre;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreServiceMock implements GenreService{
    private List<Genre> genres;

    public GenreServiceMock() {
        genres = new ArrayList<>();
        genres.add(new Genre(0,"Animation"));
        genres.add(new Genre(1,"Science-fiction"));
        genres.add(new Genre(2,"Documentaire"));
        genres.add(new Genre(3,"Action"));
        genres.add(new Genre(4,"Comédie"));
        genres.add(new Genre(5,"Drame"));
        genres.add(new Genre(6,"Thriller"));
        genres.add(new Genre(7,"Horreur"));
        genres.add(new Genre(8,"Fantastique"));
}
    @Override
    public List<Genre> getAllGenres() {
        return genres;
    }

    @Override
    public Genre getGenreById(int id) {
        return genres.get(id);
    }
}
