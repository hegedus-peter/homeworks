package xyz.codingmentor.peterhegedus11hf11jpafin.api;

import xyz.codingmentor.peterhegedus11hf11jpafin.model.Movie;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.MovieID;

/**
 *
 * @author Péter
 */
public interface CRUDMovieService {

    void createEntity(Movie entity);

    Movie getEntityById(MovieID entityId);

    Movie updateEntity(Movie entity);

    void removeEntity(MovieID entityId);

}
