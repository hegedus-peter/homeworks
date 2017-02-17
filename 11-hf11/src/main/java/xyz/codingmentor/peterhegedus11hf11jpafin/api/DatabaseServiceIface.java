package xyz.codingmentor.peterhegedus11hf11jpafin.api;

import java.util.Date;
import java.util.List;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.Director;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.Movie;

/**
 *
 * @author Péter
 */
public interface DatabaseServiceIface {

    List<Movie> getMoviesByDirector(Director director);

    List<Movie> getMoviesBeforeDate(Date date);

    List<Movie> getMoviesByDirectorOrderedByTitle(Director director);

    void removeMoviesFromStudio(String studio);

    void removeMoviesWithDirector(Director director);

}
