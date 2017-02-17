package xyz.codingmentor.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Péter
 */
@Entity
public class Movie implements Serializable{
    @Id @GeneratedValue()
    private Long id;
    
    private String title;
    @ManyToMany(mappedBy = "movies", cascade = {CascadeType.PERSIST})
    private List<Actor> actors;
    @OneToMany(mappedBy = "movie", cascade = {CascadeType.PERSIST})
    private List<Trailer> trailers;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Trailer> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", title=" + title + ", category=" + category + '}';
    }
    
    

}
