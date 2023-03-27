//package fr.eni.filmotheque.controller;
//
//import fr.eni.filmotheque.bo.Movie;
//import fr.eni.filmotheque.service.MovieServiceMock;
//import org.junit.jupiter.api.Test;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//class MovieControllerTest {
////    MovieController movieController = new MovieController(new MovieServiceMock());
//
//    @Test
//    void testFindMovieParID() {
//        //GIVEN
//        long id = 1;
//        //WHEN
//        Optional<Movie> movie = movieController.findMovie(id);
//        //THEN
//        assertTrue(movie.isPresent());
//    }
//
//    @Test
//    void testIDFindMovieParID() {
//        //GIVEN
//        long id = 1;
//        //WHEN
//        Optional<Movie> movie = movieController.findMovie(id);
//        //THEN
//        assertEquals(1L, movie.get().getId());
//    }
//
//}
