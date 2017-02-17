package xyz.codingmentor.peterhegedus11hf11jpafin.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Péter
 */
public class MovieID implements Serializable {

    private String title;
    private String studio;

    public MovieID() {
        //generated
    }

    public MovieID(String title, String studio) {
        this.title = title;
        this.studio = studio;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.title);
        hash = 83 * hash + Objects.hashCode(this.studio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MovieID other = (MovieID) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        return true;
    }

}
