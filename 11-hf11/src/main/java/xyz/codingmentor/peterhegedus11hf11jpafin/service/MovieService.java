package xyz.codingmentor.peterhegedus11hf11jpafin.service;

import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.peterhegedus11hf11jpafin.api.CRUDMovieService;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.Movie;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.MovieID;
import xyz.codingmentor.peterhegedus11hf11jpafin.repository.MovieRepository;

/**
 *
 * @author Péter
 */
@Stateless
public class MovieService implements CRUDMovieService {

    @Inject
    private MovieRepository repository;

    @Override
    public void createEntity(Movie entity) {
        repository.persist(entity);
    }

    @Override
    public Movie getEntityById(MovieID entityId) {
        return repository.find(entityId);
    }

    @Override
    public Movie updateEntity(Movie entity) {
        return repository.merge(entity);
    }

    @Override
    public void removeEntity(MovieID entityId) {
        repository.remove(entityId);
    }

    @PreDestroy
    public void close() {
        repository.close();
    }

}
