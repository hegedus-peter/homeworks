package xyz.codingmentor.peterhegedus11hf11jpafin.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Péter
 */
@Entity
public class Director implements Serializable {

    @Id
    @GeneratedValue
    private Long directorID;

    @Embedded
    private PersonAttribute personAttribute;

    @OneToMany(mappedBy = "director")
    private List<Movie> directedMovies;

    public Director() {
        //generated
    }

    public Director(PersonAttribute personAttribute, List<Movie> directedMovies) {
        this.personAttribute = personAttribute;
        this.directedMovies = directedMovies;
    }

    public Long getDirectorID() {
        return directorID;
    }

    public void setDirectorID(Long directorID) {
        this.directorID = directorID;
    }

    public PersonAttribute getPersonAttribute() {
        return personAttribute;
    }

    public void setPersonAttribute(PersonAttribute personAttribute) {
        this.personAttribute = personAttribute;
    }

    public List<Movie> getDirectedMovies() {
        return directedMovies;
    }

    public void setDirectedMovies(List<Movie> directedMovies) {
        this.directedMovies = directedMovies;
    }

}
