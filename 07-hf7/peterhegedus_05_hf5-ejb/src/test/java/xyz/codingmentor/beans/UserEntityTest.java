package xyz.codingmentor.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import static xyz.codingmentor.beans.Sex.MALE;

/**
 *
 * @author Péter
 */
public class UserEntityTest {

    private static ValidatorFactory vf;
    private static Validator validator;

    private static String username;
    private static String password;
    private static String firstName;
    private static String lastName;
    private static String address;
    private static String phone;
    private static String email;
    private static Sex sex;
    private static Date regDate;
    private static Date modDate;
    private static Date birthDate;
    private static final Calendar CALENDAR = Calendar.getInstance();

    @BeforeClass
    public static void init() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();

        username = "pistike";
        password = "Abc12d";
        firstName = "Istvan";
        lastName = "Kiss";
        address = "1234 Budapest, Valami utca 2.";
        phone = "06301234567";
        email = "pistike@ize.hu";
        sex = MALE;
        CALENDAR.add(Calendar.YEAR, -3);
        regDate = CALENDAR.getTime();
        CALENDAR.add(Calendar.YEAR, 1);
        modDate = CALENDAR.getTime();
        CALENDAR.add(Calendar.YEAR, -10);
        birthDate = CALENDAR.getTime();
    }

    @AfterClass
    public static void close() {
        vf.close();
    }

    @Test
    public void shouldRaiseNoConstraintViolation() {

        UserEntity user = new UserEntity.Builder()
                .username(username)
                .password(password)
                .firstname(firstName)
                .lastname(lastName)
                .address(address)
                .phone(phone)
                .email(email)
                .sex(sex)
                .registrationDate(regDate)
                .lastModifiedDate(modDate)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();

        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseUsernameNull() {
        UserEntity user = new UserEntity.Builder()
                .username(null)
                .password(password)
                .firstname(firstName)
                .lastname(lastName)
                .address(address)
                .phone(phone)
                .email(email)
                .sex(sex)
                .registrationDate(regDate)
                .lastModifiedDate(modDate)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseUsernameShort() {
        String wrongUsername = "pisti";
        UserEntity user = new UserEntity.Builder()
                .username(wrongUsername)
                .password(password)
                .firstname(firstName)
                .lastname(lastName)
                .address(address)
                .phone(phone)
                .email(email)
                .sex(sex)
                .registrationDate(regDate)
                .lastModifiedDate(modDate)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongUsername, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void shouldRaiseConstraintViolationCausePasswordNull() {
        UserEntity user = new UserEntity.Builder()
                .username(username)
                .password(null)
                .firstname(firstName)
                .lastname(lastName)
                .address(address)
                .phone(phone)
                .email(email)
                .sex(sex)
                .registrationDate(regDate)
                .lastModifiedDate(modDate)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void shouldRaiseConstraintViolationCausePasswordWrong() {
        String wrongPassword = "pisti";
        UserEntity user = new UserEntity.Builder()
                .username(username)
                .password(wrongPassword)
                .firstname(firstName)
                .lastname(lastName)
                .address(address)
                .phone(phone)
                .email(email)
                .sex(sex)
                .registrationDate(regDate)
                .lastModifiedDate(modDate)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongPassword, violations.iterator().next().getInvalidValue());
        Assert.assertEquals("{Password.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseAddressWrong() {
        String wrongAddress = "12e4 Budapest, Valami utca 2.";
        UserEntity user = new UserEntity.Builder()
                .username(username)
                .password(password)
                .firstname(firstName)
                .lastname(lastName)
                .address(wrongAddress)
                .phone(phone)
                .email(email)
                .sex(sex)
                .registrationDate(regDate)
                .lastModifiedDate(modDate)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongAddress, violations.iterator().next().getInvalidValue());
        Assert.assertEquals("{Address.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void shouldRaiseConstraintViolationCausePhoneWrong() {
        String wrongPhone = "+351234567";
        UserEntity user = new UserEntity.Builder()
                .username(username)
                .password(password)
                .firstname(firstName)
                .lastname(lastName)
                .address(address)
                .phone(wrongPhone)
                .email(email)
                .sex(sex)
                .registrationDate(regDate)
                .lastModifiedDate(modDate)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongPhone, violations.iterator().next().getInvalidValue());
        Assert.assertEquals("{Phone.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseEmailNull() {
        UserEntity user = new UserEntity.Builder()
                .username(username)
                .password(password)
                .firstname(firstName)
                .lastname(lastName)
                .address(address)
                .phone(phone)
                .email(null)
                .sex(sex)
                .registrationDate(regDate)
                .lastModifiedDate(modDate)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
        Assert.assertEquals("{Email.message}", violations.iterator().next().getMessageTemplate());

    }

    @Test
    public void shouldRaiseConstraintViolationCauseEmailWrong() {
        String wrongEmail = "pistike&ize.hu";
        UserEntity user = new UserEntity.Builder()
                .username(username)
                .password(password)
                .firstname(firstName)
                .lastname(lastName)
                .address(address)
                .phone(phone)
                .email(wrongEmail)
                .sex(sex)
                .registrationDate(regDate)
                .lastModifiedDate(modDate)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongEmail, violations.iterator().next().getInvalidValue());
        Assert.assertEquals("{Email.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseRegDateNull() {
        UserEntity user = new UserEntity.Builder()
                .username(username)
                .password(password)
                .firstname(firstName)
                .lastname(lastName)
                .address(address)
                .phone(phone)
                .email(email)
                .sex(sex)
                .registrationDate(null)
                .lastModifiedDate(modDate)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseRegDateWrong() {
        CALENDAR.add(Calendar.YEAR, +1000);
        Date wrongRegDate = CALENDAR.getTime();
        UserEntity user = new UserEntity.Builder()
                .username(username)
                .password(password)
                .firstname(firstName)
                .lastname(lastName)
                .address(address)
                .phone(phone)
                .email(email)
                .sex(sex)
                .registrationDate(wrongRegDate)
                .lastModifiedDate(modDate)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongRegDate, violations.iterator().next().getInvalidValue());
    }

    @Test()
    public void shouldRaiseConstraintViolationCauseModDateNull() {
        UserEntity user = new UserEntity.Builder()
                .username(username)
                .password(password)
                .firstname(firstName)
                .lastname(lastName)
                .address(address)
                .phone(phone)
                .email(email)
                .sex(sex)
                .registrationDate(regDate)
                .lastModifiedDate(null)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseModDateWrong() {
        CALENDAR.add(Calendar.YEAR, +1000);
        Date wrongModDate = CALENDAR.getTime();
        UserEntity user = new UserEntity.Builder()
                .username(username)
                .password(password)
                .firstname(firstName)
                .lastname(lastName)
                .address(address)
                .phone(phone)
                .email(email)
                .sex(sex)
                .registrationDate(regDate)
                .lastModifiedDate(wrongModDate)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongModDate, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseFirstNameNull() {
        UserEntity user = new UserEntity.Builder()
                .username(username)
                .password(password)
                .firstname(null)
                .lastname(lastName)
                .address(address)
                .phone(phone)
                .email(email)
                .sex(sex)
                .registrationDate(regDate)
                .lastModifiedDate(modDate)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(user, violations.iterator().next().getInvalidValue());
        Assert.assertEquals("{UserEntityName.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseLastNameNull() {
        UserEntity user = new UserEntity.Builder()
                .username(username)
                .password(password)
                .firstname(firstName)
                .lastname(null)
                .address(address)
                .phone(phone)
                .email(email)
                .sex(sex)
                .registrationDate(regDate)
                .lastModifiedDate(modDate)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(user, violations.iterator().next().getInvalidValue());
        Assert.assertEquals("{UserEntityName.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseBirthDateRegDate() {
        CALENDAR.add(Calendar.YEAR, 10);
        Date wrongBirthDate = CALENDAR.getTime();
        UserEntity user = new UserEntity.Builder()
                .username(username)
                .password(password)
                .firstname(firstName)
                .lastname(lastName)
                .address(address)
                .phone(phone)
                .email(email)
                .sex(sex)
                .registrationDate(regDate)
                .lastModifiedDate(modDate)
                .dateOfBirth(wrongBirthDate)
                .admin(false)
                .build();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(user, violations.iterator().next().getInvalidValue());
        Assert.assertEquals("{UserEntityDate.message}", violations.iterator().next().getMessageTemplate());
    }
}
