package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.bo.Member;
import fr.eni.filmotheque.bo.Movie;
import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.dal.GenreDao;
import fr.eni.filmotheque.dal.MovieDao;
import fr.eni.filmotheque.dal.ParticipantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private List<Member> members;
    private List<Movie> movies;
    private List<Genre> genres;
    private List<Participant> participants;
    @Autowired
    MovieDao movieDao;
    @Autowired
    GenreDao genreDao;
    @Autowired
    ParticipantDao participantDao;
    @Override
    public List<Movie> getAllMovies() {
        movies = movieDao.findAll();
        System.out.println(movies);
        return movies;
    }

    @Override
    public Optional<Movie> getMovieById(long id) {
        Optional<Movie> movie = movieDao.findById(id);
        return movie;
    }

    @Override
    public List<Genre> getGenres() {
        genres = genreDao.findAll();
        return genres;
    }

    @Override
    public List<Participant> getParticipants() {
        participants = participantDao.findAll();
        return participants;
    }

    @Override
    public Genre getGenreById(long id) {
        Optional<Genre> genre = genreDao.findById(id);
        return genre.get();
    }

    @Override
    public Participant getParticipantsById(long id) {
        Optional<Participant> participant = participantDao.findById(id);
        return participant.get();
    }

    @Override
    public void saveMovie(Movie movie) {
        movieDao.save(movie);
    }
}
