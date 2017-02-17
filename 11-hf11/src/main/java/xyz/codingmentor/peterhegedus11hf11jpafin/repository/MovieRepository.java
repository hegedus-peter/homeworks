package xyz.codingmentor.peterhegedus11hf11jpafin.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import xyz.codingmentor.peterhegedus11hf11jpafin.api.CRUDMovieRepository;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.Movie;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.MovieID;

/**
 *
 * @author Péter
 */
@Stateless
public class MovieRepository implements CRUDMovieRepository {

    private final EntityManagerFactory factory;
    private final EntityManager entityManager;

    public MovieRepository() {
        factory = Persistence.createEntityManagerFactory("hf11PU");
        entityManager = factory.createEntityManager();
    }

    @Override
    public void persist(Movie entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(entity);
        tx.commit();
    }

    @Override
    public Movie find(MovieID entityId) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Movie actMovie = entityManager.find(Movie.class, entityId);
        tx.commit();
        return actMovie;
    }

    @Override
    public Movie merge(Movie entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Movie actMovie = entityManager.merge(entity);
        tx.commit();
        return actMovie;
    }

    @Override
    public void remove(MovieID entityId) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(entityId);
        tx.commit();
    }

    public void close() {
        entityManager.close();
        factory.close();
    }

}
