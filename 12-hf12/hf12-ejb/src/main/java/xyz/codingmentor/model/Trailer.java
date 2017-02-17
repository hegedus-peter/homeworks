package xyz.codingmentor.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Péter
 */
@Entity
public class Trailer implements Serializable {

    @Id
    @GeneratedValue()
    private Long id;

    private String url;
    @Enumerated(EnumType.STRING)
    private TrailerType type;
    private String title;
    @Temporal(TemporalType.DATE)
    private Date publicDate;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Movie movie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TrailerType getType() {
        return type;
    }

    public void setType(TrailerType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Trailer{" + "id=" + id + ", url=" + url + ", type=" + type + ", title=" + title + ", publicDate=" + publicDate + '}';
    }

}
