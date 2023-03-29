package fr.eni.filmotheque.bo;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 0, message = "L'id doit être supérieur à 0")
    private long id;
    @NotBlank(message = "Le titre ne doit pas être vide")
    @Size(min = 3, max = 50, message = "Le titre doit être compris entre 3 et 50 caractères")
    private String title;
    @Digits(integer = 4, fraction = 0, message = "L'année doit être à un format valide (4 chiffres)")
    @Min(value = 1900, message = "L'année doit être supérieure à 1900")
    private int year;
    private int duration;
    private String synopsis;
    @ManyToOne
    private Genre genre;
    @ManyToOne
    private Participant director;
    private String urlImage;
    @ManyToMany
    private List<Participant> actors;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "movie_id")
    private List<Opinion> opinions;

    public  Movie(){
        setActors(null);
    }

    public Movie(long id, String title, int year, int duration, String synopsis, Genre genre, Participant director) {
        this();
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
        this.genre = genre;
        this.director = director;
        this.opinions = new ArrayList<>();
    }
    public Movie(String title, int year, int duration, String synopsis, Genre genre, Participant director) {
        this();
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
        this.genre = genre;
        this.director = director;
        this.opinions = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Movie[" + "id=" + id +
                ']' +
                '\n' +
                "     title: " + title + ' ' +
                '[' +
                "year: " + year +
                ", duration: " + duration +
                ']' +
                '\n' +
                "     Synopsis:'" + synopsis + '\'' +
                '\n' +
                "     Director: " + director +
                '\n' +
                "     Actors: " + actors +
                '\n' +
                "     genre: " + genre;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public List<Participant> getActors() {
        return actors;
    }
    public void setActors(List<Participant> actors) {
        if(actors == null) {
            this.actors = new ArrayList<>();
        }
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Participant getDirector() {
        return director;
    }

    public void setDirector(Participant director) {
        this.director = director;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public List<Opinion> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<Opinion> opinions) {
        this.opinions = opinions;
    }
}