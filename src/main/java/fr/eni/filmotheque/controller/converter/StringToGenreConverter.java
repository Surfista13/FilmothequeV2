package fr.eni.filmotheque.controller.converter;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StringToGenreConverter implements Converter <String, Genre>{
    private Genre genre;
    private GenreService genreService;

    public StringToGenreConverter(GenreService genreService) {
        this.genreService = genreService;
    }

    @Override
    public Genre convert(String idGenre) {
        Genre genre = null;
        try {
            int id = Integer.parseInt(idGenre);
            genre = genreService.getGenreById(id);
        } catch (NumberFormatException e) {
        }
        return genre;
    }
}
