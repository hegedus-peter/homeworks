package xyz.codingmentor.peterhegedus11hf11jpafin.service;

import java.util.Date;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import xyz.codingmentor.peterhegedus11hf11jpafin.api.DatabaseServiceIface;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.Director;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.Movie;

/**
 *
 * @author Péter
 */
@Stateless
public class DatabaseService implements DatabaseServiceIface {

    private final EntityManagerFactory factory;
    private final EntityManager entityManager;
    
    private static final String DIRECTOR = "director";

    public DatabaseService() {
        factory = Persistence.createEntityManagerFactory("hf11PU");
        entityManager = factory.createEntityManager();
    }

    @Override
    public List<Movie> getMoviesByDirector(Director director) {
        TypedQuery<Movie> query = entityManager.createQuery("SELECT m FROM Movie m where m.director = :director", Movie.class);
        query.setParameter(DIRECTOR, director);
        return query.getResultList();
    }

    @Override
    public List<Movie> getMoviesBeforeDate(Date date) {
        TypedQuery<Movie> query = entityManager.createQuery("SELECT m FROM Movie m where m.releaseDate < :date", Movie.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    @Override
    public List<Movie> getMoviesByDirectorOrderedByTitle(Director director) {
        Query query = entityManager.createQuery("SELECT m FROM Movie m where m.director = :director ORDER BY m.title ASC", Movie.class);
        query.setParameter(DIRECTOR, director);
        return query.getResultList();
    }

    @Override
    public void removeMoviesFromStudio(String studio) {
        Query query = entityManager.createQuery("DELETE FROM Movie m where m.studio = :studio");
        query.setParameter("studio", studio);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        query.executeUpdate();
        tx.commit();
    }

    @Override
    public void removeMoviesWithDirector(Director director) {
        Query query = entityManager.createQuery("DELETE FROM Movie m where m.director = :director");
        query.setParameter(DIRECTOR, director);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        query.executeUpdate();
        tx.commit();
    }

    @PreDestroy
    public void close() {
        entityManager.close();
        factory.close();
    }

}
