package xyz.codingmentor.peterhegedus11hf11jpafin.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Péter
 */
@Entity
public class Actor implements Serializable {

    @Id
    @GeneratedValue
    private Long actorId;

    @Embedded
    private PersonAttribute personAttribute;

    private boolean hasOscar;

    @ManyToMany
    @JoinTable(name = "jnd_mov_act")
    private List<Movie> actsInMovies;

    public Actor() {
        //generated
    }

    public Actor(PersonAttribute personAttribute, boolean hasOscar, List<Movie> actsInMovies) {
        this.personAttribute = personAttribute;
        this.hasOscar = hasOscar;
        this.actsInMovies = actsInMovies;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public PersonAttribute getPersonAttribute() {
        return personAttribute;
    }

    public void setPersonAttribute(PersonAttribute personAttribute) {
        this.personAttribute = personAttribute;
    }

    public boolean isHasOscar() {
        return hasOscar;
    }

    public void setHasOscar(boolean hasOscar) {
        this.hasOscar = hasOscar;
    }

    public List<Movie> getActsInMovies() {
        return actsInMovies;
    }

    public void setActsInMovies(List<Movie> actsInMovies) {
        this.actsInMovies = actsInMovies;
    }

}
