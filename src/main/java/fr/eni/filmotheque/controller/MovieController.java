package fr.eni.filmotheque.controller;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.bo.Movie;
import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.service.GenreService;
import fr.eni.filmotheque.service.MovieService;
import fr.eni.filmotheque.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {

    private MovieService movieService;
    private GenreService genreService;
    private ParticipantService participantService;


    @Autowired
    public MovieController(MovieService movieService, GenreService genreService, ParticipantService participantService) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.participantService = participantService;
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

    /**
     * Méthode permettant de renvoyer la liste des films ainsi que la date et heure au moment de l'appel
     * @param model injection du Model
     * @return renvoi vers la page d'accueil avec la liste des films
     */
    @GetMapping("/")
    public String listeDesFilms(Model model,HttpSession session){
        List<Movie> movies = movieService.getAllMovies();
        LocalDateTime date = LocalDateTime.now();
        model.addAttribute("movies", movies);
        model.addAttribute("localDateTime", date);
        LocalDateTime dateConnexion= LocalDateTime.now();
        if(session.getAttribute("dateConnexion") == null){
            session.setAttribute("dateConnexion", dateConnexion);
        }
        return "accueil";
    }

    /**
     * Méthode permettant de renvoyer un film en fonction de son id. Si l'id n'est pas connu renvoi vers une page 404
     * @param id clé primaire du film en base
     * @param model injection du Model
     * @return renvoi vers la page détail film ou vers page 404
     */
    @GetMapping("/detailfilm/{id}")
    public String detailFilm(@PathVariable(value="id") long id, Model model){
        String dataToReturn;
        Optional<Movie> movie = movieService.getMovieById(id);
        if(movie.isEmpty()){
            dataToReturn = "error";
            model.addAttribute("erreur", 404);
        } else {
            model.addAttribute("movie", movie.get());
            dataToReturn = "detail";
        }
        return dataToReturn;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/addfilm")
    public String addFilm(HttpSession session,Model model){
        String  dataToReturn;
        if(session.getAttribute("isConnected") != null){
            List<Genre> genres = genreService.getAllGenres();
            List<Participant> participants = participantService.getAllParticipants();
            model.addAttribute("genres", genres);
            model.addAttribute("participants", participants);
            dataToReturn = "ajoutFilm";
        } else {
            dataToReturn = "redirect:/";
        }
        return dataToReturn;
    }
    @PostMapping("/addfilm")
    public String addFilm(Movie movie,HttpSession session){
        movie.setUrlImage("/images/1.png");
        movieService.getAllMovies().add(movie);
        return "redirect:/";
    }
}
