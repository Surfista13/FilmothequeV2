package fr.eni.filmotheque.controller;

import fr.eni.filmotheque.bo.Movie;
import fr.eni.filmotheque.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     *Méthode renvoyant la liste des tous films
     * @return une ArrayList de type Movie
     */
    public List<Movie> showAllMovies(){
        return movieService.getAllMovies();
    }

    /**
     * Méthode renvoyant un film par son id
     * @param id clé primaire du film
     * @return un Optional de type Movie
     */
    public Optional<Movie> findMovie(long id){
        return movieService.getMovieById(id);
    }

    @GetMapping("/")
    public String home(){
        return "accueil";
    }
    @GetMapping("/vuefilms")
    public String listeDesFilms(Model model){
        List<Movie> movies = movieService.getAllMovies();
        LocalDateTime date = LocalDateTime.now();
        model.addAttribute("movies", movies);
        model.addAttribute("localDateTime", date);
        return "vuefilms";
    }

    @GetMapping("/detailfilm/{id}")
    public String detailFilm(@PathVariable(value="id") long id, Model model){
        Movie movie = movieService.getMovieById(id).get();
        model.addAttribute("movie", movie);
        return "detailfilm";
    }


}
