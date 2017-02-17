package xyz.codingmentor.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.model.Actor;
import xyz.codingmentor.model.Movie;
import xyz.codingmentor.model.Trailer;

/**
 *
 * @author Péter
 */
@Stateless
public class Joiner {

    @PersistenceContext(unitName = "movieServicePU")
    private EntityManager entityManager;

    public void fixMovieTrailer(Movie movie, Trailer trailer) {
        trailer.setMovie(movie);
        entityManager.merge(trailer);
    }

    public void fixMovieActor(Movie movie, Actor actor) {
        List<Movie> movieList = actor.getMovies();
        if (null != movieList && !movieList.contains(movie)) {
            movieList.add(movie);
        } else {
            movieList = new ArrayList<>();
            movieList.add(movie);
        }
        actor.setMovies(movieList);
        entityManager.merge(actor);
    }

}
