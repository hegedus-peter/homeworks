package xyz.codingmentor.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import xyz.codingmentor.constraint.Password;
import xyz.codingmentor.constraint.Address;
import xyz.codingmentor.constraint.Email;
import xyz.codingmentor.constraint.Phone;
import xyz.codingmentor.constraint.UserEntityDateAnnotation;
import xyz.codingmentor.constraint.UserEntityNameAnnotation;
import xyz.codingmentor.constraint.Validable;

/**
 *
 * @author Péter
 */
@UserEntityDateAnnotation
@UserEntityNameAnnotation
@Validable
public class UserEntity implements Serializable {

    @Size(min = 6)
    @NotNull
    private String username;
    @Password
    private String password;
    private String firstname;
    private String lastname;
    @Address
    private String address;
    @Phone
    private String phone;
    @Email
    private String email;
    private Sex sex;
    @NotNull
    @Past
    private Date registrationDate;
    @NotNull
    @Past
    private Date lastModifiedDate;
    private Date dateOfBirth;
    private boolean admin;

    public UserEntity() {
        //Empty constructor needed for JSON read
    }

    private UserEntity(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.address = builder.address;
        this.phone = builder.phone;
        this.email = builder.email;
        this.sex = builder.sex;
        this.registrationDate = builder.registrationDate;
        this.lastModifiedDate = builder.lastModifiedDate;
        this.dateOfBirth = builder.dateOfBirth;
        this.admin = builder.admin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Sex getSex() {
        return sex;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Objects.hashCode(this.password);
        hash = 97 * hash + Objects.hashCode(this.firstname);
        hash = 97 * hash + Objects.hashCode(this.lastname);
        hash = 97 * hash + Objects.hashCode(this.address);
        hash = 97 * hash + Objects.hashCode(this.phone);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.sex);
        hash = 97 * hash + Objects.hashCode(this.registrationDate);
        hash = 97 * hash + Objects.hashCode(this.lastModifiedDate);
        hash = 97 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 97 * hash + (this.admin ? 1 : 0);
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
        final UserEntity other = (UserEntity) obj;
        if (this.admin != other.admin) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (this.sex != other.sex) {
            return false;
        }
        if (!Objects.equals(this.registrationDate, other.registrationDate)) {
            return false;
        }
        if (!Objects.equals(this.lastModifiedDate, other.lastModifiedDate)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserEntity{" + "username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", phone=" + phone + ", email=" + email + ", sex=" + sex + ", registrationDate=" + registrationDate + ", lastModifiedDate=" + lastModifiedDate + ", dateOfBirth=" + dateOfBirth + ", admin=" + admin + '}';
    }

    public static class Builder {

        private String username;
        private String password;
        private String firstname;
        private String lastname;
        private String address;
        private String phone;
        private String email;
        private Sex sex;
        private Date registrationDate;
        private Date lastModifiedDate;
        private Date dateOfBirth;
        private boolean admin;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder sex(Sex sex) {
            this.sex = sex;
            return this;
        }

        public Builder registrationDate(Date registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder lastModifiedDate(Date lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public Builder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder admin(boolean admin) {
            this.admin = admin;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this);
        }
    }

}
