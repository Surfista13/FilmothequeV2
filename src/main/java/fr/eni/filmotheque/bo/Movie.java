package fr.eni.filmotheque.bo;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private long id;
    private String title;
    private int year;
    private int duration;
    private String synopsis;
    private Genre genre;
    private Participant director;
    private List<Participant> actors;

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

}