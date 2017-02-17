package xyz.codingmentor.peterhegedus11hf11jpafin.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.inject.Inject;
import org.jboss.logging.Logger;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.Actor;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.Director;
import static xyz.codingmentor.peterhegedus11hf11jpafin.model.Gender.FEMALE;
import static xyz.codingmentor.peterhegedus11hf11jpafin.model.Gender.MALE;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.Movie;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.MovieID;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.PersonAttribute;
import xyz.codingmentor.peterhegedus11hf11jpafin.service.ActorService;
import xyz.codingmentor.peterhegedus11hf11jpafin.service.DatabaseService;
import xyz.codingmentor.peterhegedus11hf11jpafin.service.DirectorService;
import xyz.codingmentor.peterhegedus11hf11jpafin.service.MovieService;

/**
 *
 * @author Péter
 */
public class Application {

    @Inject
    private MovieService movieService;

    @Inject
    private ActorService actorService;

    @Inject
    private DirectorService directorService;

    @Inject
    private DatabaseService databaseService;

    private static final Logger LOG = Logger.getLogger(Application.class.getName());

    private Actor actor1;
    private Actor actor2;
    private Actor actor3;

    private Director director1;
    private Director director2;

    private Movie movie1;
    private Movie movie2;
    private Movie movie3;

    public void initMovies() {
        Calendar calendar1 = new GregorianCalendar(2017, 1, 11);
        Calendar calendar2 = new GregorianCalendar(2016, 2, 14);
        Calendar calendar3 = new GregorianCalendar(2012, 11, 15);

        movie1 = new Movie(new MovieID("title1", "studio1"), calendar1.getTime(), director1, new ArrayList<Actor>());
        movie2 = new Movie(new MovieID("title2", "studio2"), calendar2.getTime(), director2, new ArrayList<Actor>());
        movie3 = new Movie(new MovieID("title3", "studio3"), calendar3.getTime(), director1, new ArrayList<Actor>());
    }

    public void initActors() {
        actor1 = new Actor(new PersonAttribute(MALE, "firstName1", "lastName1"), false, new ArrayList<Movie>());
        actor2 = new Actor(new PersonAttribute(MALE, "firstName2", "lastName2"), false, new ArrayList<Movie>());
        actor3 = new Actor(new PersonAttribute(MALE, "firstName3", "lastName3"), true, new ArrayList<Movie>());
    }

    public void initDirectors() {
        director1 = new Director(new PersonAttribute(MALE, "firstName4", "lastName4"), new ArrayList<Movie>());
        director2 = new Director(new PersonAttribute(FEMALE, "firstName5", "lastName5"), new ArrayList<Movie>());
    }

    public void joinTables() {
        movie1.getActors().add(actor1);
        movie1.getActors().add(actor2);
        actor1.getActsInMovies().add(movie1);
        actor2.getActsInMovies().add(movie1);
        movie1.setDirector(director1);
        director1.getDirectedMovies().add(movie1);
        movieService.updateEntity(movie1);
        actorService.updateEntity(actor1);
        actorService.updateEntity(actor2);
        directorService.updateEntity(director1);

        movie2.getActors().add(actor1);
        movie2.getActors().add(actor2);
        movie2.getActors().add(actor3);
        actor1.getActsInMovies().add(movie2);
        actor2.getActsInMovies().add(movie2);
        actor3.getActsInMovies().add(movie2);
        movie2.setDirector(director2);
        director2.getDirectedMovies().add(movie2);
        movieService.updateEntity(movie2);
        actorService.updateEntity(actor1);
        actorService.updateEntity(actor2);
        actorService.updateEntity(actor3);
        directorService.updateEntity(director2);

        movie3.getActors().add(actor3);
        actor3.getActsInMovies().add(movie3);
        movie3.setDirector(director1);
        director1.getDirectedMovies().add(movie3);
        movieService.updateEntity(movie3);
        actorService.updateEntity(actor3);
        directorService.updateEntity(director1);
    }

    public void initDB() {
        actorService.createEntity(actor1);
        actorService.createEntity(actor2);
        actorService.createEntity(actor3);

        directorService.createEntity(director1);
        directorService.createEntity(director2);

        movieService.createEntity(movie1);
        movieService.createEntity(movie2);
        movieService.createEntity(movie3);

    }

    public void databaseQueries() {
        Calendar calendar = new GregorianCalendar(2017, 1, 10);
        List<Movie> result1 = databaseService.getMoviesBeforeDate(calendar.getTime());
        List<Movie> result2 = databaseService.getMoviesByDirector(director1);
        List<Movie> result3 = databaseService.getMoviesByDirectorOrderedByTitle(director1);
        databaseService.removeMoviesFromStudio("studio1");
        databaseService.removeMoviesWithDirector(director2);

        LOG.log(Logger.Level.INFO, result1.toString());
        LOG.log(Logger.Level.INFO, result2.toString());
        LOG.log(Logger.Level.INFO, result3.toString());
    }

    public void run() {
        initMovies();
        initDirectors();
        initActors();
        initDB();
        joinTables();
        databaseQueries();

    }

}
