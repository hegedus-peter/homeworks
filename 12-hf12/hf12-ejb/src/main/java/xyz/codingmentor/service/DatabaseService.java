package xyz.codingmentor.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import xyz.codingmentor.model.Actor;
import xyz.codingmentor.model.Category;
import xyz.codingmentor.model.Movie;
import xyz.codingmentor.model.Trailer;

/**
 *
 * @author Péter
 */
@Stateless
public class DatabaseService {

    @PersistenceContext(unitName = "movieServicePU")
    private EntityManager entityManager;

    public List<Actor> getMovieActor(Movie movie) {
        TypedQuery<Actor> query = entityManager.createQuery("select a from Actor a inner join a.movies m where m = :movie", Actor.class);
        query.setParameter("movie", movie);
        return query.getResultList();
    }

    public List<Actor> getNameActor(String firstName, String lastName) {
        TypedQuery<Actor> query = entityManager.createQuery("SELECT a FROM Actor a WHERE a.firstName = :firstName AND a.lastName = :lastName", Actor.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    public List<Actor> getNationalityActor(String nationality) {
        TypedQuery<Actor> query = entityManager.createQuery("SELECT a FROM Actor a WHERE a.nationality = :nationality", Actor.class);
        query.setParameter("nationality", nationality);
        return query.getResultList();
    }

    public List<Movie> getCategoryMovie(Category category) {
        TypedQuery<Movie> query = entityManager.createQuery("SELECT m FROM Movie m WHERE m.category = :category", Movie.class);
        query.setParameter("category", category);
        return query.getResultList();
    }

    public List<Movie> getTitleMovie(String title) {
        TypedQuery<Movie> query = entityManager.createQuery("SELECT m FROM Movie m WHERE m.title = :title", Movie.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    public List<Trailer> getMovieTrailers(Movie movie) {
        TypedQuery<Trailer> query = entityManager.createQuery("SELECT t FROM Trailer t WHERE t.movie = :movie", Trailer.class);
        query.setParameter("movie", movie);
        return query.getResultList();
    }

}
