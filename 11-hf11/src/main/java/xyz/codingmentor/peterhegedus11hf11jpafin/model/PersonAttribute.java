package xyz.codingmentor.peterhegedus11hf11jpafin.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author Péter
 */
@Embeddable
public class PersonAttribute implements Serializable {

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String firstName;
    private String lastName;

    public PersonAttribute() {
        //generated
    }

    public PersonAttribute(Gender gender, String firstName, String lastName) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
