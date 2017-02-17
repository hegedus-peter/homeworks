package xyz.codingmentor.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.api.CRUDRepoAnnotation;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Movie;

/**
 *
 * @author Péter
 */
@Stateless
@CRUDRepoAnnotation(EntityModel.MOVIE)
public class MovieRepository extends AbstractCRUDRepository<Movie> implements CRUDRepository<Movie> {

    @PersistenceContext(unitName = "movieServicePU")
    private EntityManager entityManager;

    @Override
    protected Class<Movie> getEntityClass() {
        return Movie.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
