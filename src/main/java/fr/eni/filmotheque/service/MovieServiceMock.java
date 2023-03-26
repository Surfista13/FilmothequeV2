package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.bo.Movie;
import fr.eni.filmotheque.bo.Participant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceMock implements MovieService{
    private List<Genre> genres;
    private List<Participant> participants;
    private List<Movie> movies;

    /**
     * Méthode créeant une liste de genres, une liste de participants et une liste de films
     * @since 1.0
     */
    public MovieServiceMock() {
        //Création d'une liste de genres
        extractedGenres();
        //Création d'une liste de participants
        extractedParticipants();
        //Création d'une liste de films
        extractedMovies();
        //Ajout d'acteurs aux films
        List<Participant> participants2 = new ArrayList<>();
        participants2.add(participants.get(0));
        participants2.add(participants.get(1));
        participants2.add(participants.get(2));
        participants2.add(participants.get(3));
        participants2.add(participants.get(4));
        ajoutActeurs(participants2, participants2, participants2);
    }

    private void ajoutActeurs(List<Participant> participants2, List<Participant> participants3, List<Participant> participants4) {
        movies.get(0).setActors(participants2);
        movies.get(1).setActors(participants2);
        movies.get(2).setActors(participants3);
        movies.get(3).setActors(participants3);
        movies.get(4).setActors(participants4);
        movies.get(5).setActors(participants4);
    }

    private void extractedMovies() {
        movies = new ArrayList<>();
        this.movies.add(new Movie(0,"Le parrain",1979,160,"Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression.",genres.get(5),participants.get(2)));
        this.movies.add(new Movie(1,"Le bon et la brute",1960,180,"On sait depuis longtemps que travailler avec du texte lisible,travailler avec du texte lisible",genres.get(4),participants.get(2)));
        this.movies.add(new Movie(2,"Heat",1995,120,"Plusieurs variations de Lorem Ipsum peuvent être trouvées ici ou là, mais la majeure partie d'entre elles",genres.get(2),participants.get(4)));
        this.movies.add(new Movie(3,"StarWars",1999,90,"Tous les générateurs de Lorem Ipsum sur Internet tendent à reproduire le même extrait sans fin",genres.get(8),participants.get(5)));
        this.movies.add(new Movie(4,"Didier",1980,105,"L'extrait standard de Lorem Ipsum utilisé depuis le XVIè siècle est reproduit ci-dessous pour les curieux.est reproduit ci-dessous pour les curieux.",genres.get(7),participants.get(1)));
        this.movies.add(new Movie(5,"Men in black",2020,110,"Un professeur du Hampden-Sydney College, en Virginie, s'est intéressé,College, en Virginie\"",genres.get(1),participants.get(0)));

        movies.get(0).setUrlImage("/images/1.png");
        movies.get(1).setUrlImage("/images/2.png");
        movies.get(2).setUrlImage("/images/3.png");
        movies.get(3).setUrlImage("/images/4.png");
        movies.get(4).setUrlImage("/images/5.png");
        movies.get(5).setUrlImage("/images/6.png");

    }

    private void extractedGenres() {
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

    private void extractedParticipants() {
        participants = new ArrayList<>();
        participants.add(new Participant(0,"Spielberg","Steven"));
        participants.add(new Participant(1,"Kubrick","Stanley"));
        participants.add(new Participant(2,"Tarantino","Quentin"));
        participants.add(new Participant(3,"Scorsese","Martin"));
        participants.add(new Participant(4,"Nolan","Christopher"));
        participants.add(new Participant(5,"Hitchcock","Alfred"));
        participants.add(new Participant(6,"Burton","Tim"));
        participants.add(new Participant(7,"Fincher","David"));
        participants.add(new Participant(8,"Pacino","Al"));
        participants.add(new Participant(9,"De Niro","Robert"));
        participants.add(new Participant(10,"DiCaprio","Leonardo"));
        participants.add(new Participant(11,"Eastwood","Clint"));
        participants.add(new Participant(12,"Freeman","Morgan"));
        participants.add(new Participant(13,"Depp","Johnny"));
        participants.add(new Participant(14,"Brando","Marlon"));
        participants.add(new Participant(15,"Pesci","Joe"));
        participants.add(new Participant(16,"Bergman","David"));
    }

    /**
     *Méthode renvotant la liste des films
     * @return une ArrayList d'objet Movie
     */
    @Override
    public List<Movie> getAllMovies() {
        return this.movies;
    }

    /**
     *Méthode renvoyant une film par son id
     * @param id clé primaire de l'objet Movie
     * @return un Optionnal Movie
     */
    @Override
    public Optional<Movie> getMovieById(long id) {
        Optional<Movie> optMovie= Optional.empty();
        for (Movie movie : this.movies) {
            if (movie.getId() == id) {
                optMovie = Optional.of(movie);
                break;
            }
        }
        return optMovie;
    }

    /**
     * Méthode renvoyant la liste des genres
     * @return une ArrayList d'objet Genre
     */
    @Override
    public List<Genre> getGenres() {
        return this.genres;
    }

    /**
     * Méthode renvoyant la liste des acteurs
     * @return une ArrayList d'objet Participant
     */
    @Override
    public List<Participant> getParticipants() {
        return this.participants;
    }

    /**
     * Méthode renvoyant un genre par son id
     * @param id clé primaire de l'objet Genre
     * @return un objet Genre
     */
    @Override
    public Genre getGenreById(long id) {
        Genre genreFindById = null;
        for (Genre genre : this.genres) {
            if (genre.getId() == id) {
                genreFindById = genre;
                break;
            }
        }
        return genreFindById;
    }

    /**
     * Méthode renvoyant un participant par son id
     * @param id clé primaire de l'objet Participant
     * @return un objet Participant
     */
    @Override
    public Participant getParticipantsById(long id) {
        Participant participantFindById = null;
        for (Participant value : this.participants) {
            if (value.getId() == id) {
                participantFindById = value;
                break;
            }
        }
        return participantFindById;
    }

    /**
     * Méthode sauvargant un film
     * @param movie objet de type Movie
     */
    @Override
    public void saveMovie(Movie movie) {
        this.movies.add(movie);
    }
}
