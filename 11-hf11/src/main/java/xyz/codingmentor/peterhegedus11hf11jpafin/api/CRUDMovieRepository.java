package xyz.codingmentor.peterhegedus11hf11jpafin.api;

import xyz.codingmentor.peterhegedus11hf11jpafin.model.Movie;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.MovieID;

/**
 *
 * @author Péter
 */
public interface CRUDMovieRepository {

    void persist(Movie entity);

    Movie find(MovieID entityId);

    Movie merge(Movie entity);

    void remove(MovieID entityId);

}
