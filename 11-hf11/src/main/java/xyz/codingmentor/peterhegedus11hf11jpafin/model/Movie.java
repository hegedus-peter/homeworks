package xyz.codingmentor.peterhegedus11hf11jpafin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Péter
 */
@Entity
@IdClass(MovieID.class)
public class Movie implements Serializable {

    @Id
    private String title;
    @Id
    private String studio;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Director director;

    @ManyToMany(mappedBy = "actsInMovies", cascade = {CascadeType.ALL})
    private List<Actor> actors;

    public Movie() {
        //generated
    }

    public Movie(MovieID movieID, Date releaseDate, Director director, List<Actor> actors) {
        this.title = movieID.getTitle();
        this.studio = movieID.getStudio();
        this.releaseDate = releaseDate;
        this.director = director;
        this.actors = actors;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public MovieID getMovieID() {
        return new MovieID(title, studio);
    }

    public void setMovieID(MovieID movieID) {
        this.title = movieID.getTitle();
        this.studio = movieID.getStudio();
    }

    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", studio=" + studio + ", releaseDate=" + releaseDate + ", director=" + director + ", actors=" + actors + '}';
    }

}
