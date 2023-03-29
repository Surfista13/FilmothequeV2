package fr.eni.filmotheque;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.dal.GenreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilmothequeV2Application implements CommandLineRunner {
    @Autowired
    private GenreDao genreDao;
    public static void main(String[] args) {
        SpringApplication.run(FilmothequeV2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        genreDao.save(new Genre(1, "Action"));

    }
}
