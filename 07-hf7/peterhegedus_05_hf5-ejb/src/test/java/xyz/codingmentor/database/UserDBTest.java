package xyz.codingmentor.database;

import java.util.Calendar;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import xyz.codingmentor.beans.Sex;
import static xyz.codingmentor.beans.Sex.MALE;
import xyz.codingmentor.beans.UserEntity;
import xyz.codingmentor.exceptions.UserDBAlreadyThereException;
import xyz.codingmentor.exceptions.UserDBNotFoundException;

/**
 *
 * @author Péter
 */
public class UserDBTest {

    private static UserDB userDB;
    private static UserEntity user1;
    private static UserEntity user2;

    private static String username;
    private static String password;
    private static String firstName;
    private static String lastName;
    private static String address;
    private static String phone;
    private static String email;
    private static Sex sex;
    private static Date birthDate;
    private static final Calendar CALENDAR = Calendar.getInstance();

    public UserDBTest() {
    }

    @BeforeClass
    public static void init() {

        username = "pistike";
        password = "Abc12d";
        firstName = "Istvan";
        lastName = "Kiss";
        address = "1234 Budapest, Valami utca 2.";
        phone = "06301234567";
        email = "pistike@ize.hu";
        sex = MALE;
        CALENDAR.add(Calendar.YEAR, -10);
        birthDate = CALENDAR.getTime();

        user1 = new UserEntity.Builder()
                .username(username)
                .password(password)
                .firstname(firstName)
                .lastname(lastName)
                .address(address)
                .phone(phone)
                .email(email)
                .sex(sex)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();

        username = "pistike2";
        password = "Abc12d2";

        user2 = new UserEntity.Builder()
                .username(username)
                .password(password)
                .firstname(firstName)
                .lastname(lastName)
                .address(address)
                .phone(phone)
                .email(email)
                .sex(sex)
                .dateOfBirth(birthDate)
                .admin(false)
                .build();
    }

    @Before
    public void beforeTest() {
        userDB = new UserDB();
    }

    @Test
    public void testAddUserGood() {
        assertEquals(true, userDB.getAllUser().isEmpty());
        assertEquals(user1, userDB.addUser(user1));
        assertEquals(false, userDB.getAllUser().isEmpty());
    }

    @Test(expected = UserDBAlreadyThereException.class)
    public void testAddUserBad() {
        assertEquals(true, userDB.getAllUser().isEmpty());
        userDB.addUser(user1);
        userDB.addUser(user1);
    }

    @Test
    public void testGetUserGood() {
        userDB.addUser(user1);
        userDB.addUser(user2);
        assertEquals(user2, userDB.getUser(user2.getUsername()));

    }

    @Test(expected = UserDBNotFoundException.class)
    public void testGetUserBad() {
        userDB.addUser(user1);
        userDB.getUser(user2.getUsername());

    }

    @Test
    public void testAuthenticateGood() {
        userDB.addUser(user1);
        assertEquals(true, userDB.authenticate(user1.getUsername(), user1.getPassword()));
    }

    @Test
    public void testAuthenticateBad() {
        userDB.addUser(user1);
        assertEquals(false, userDB.authenticate("wrongname", user1.getPassword()));
    }

    @Test
    public void testModifyUserGood() {
        userDB.addUser(user1);
        userDB.addUser(user2);
        assertEquals(user2, userDB.modifyUser(user2));
    }

    @Test(expected = UserDBNotFoundException.class)
    public void testModifyUserBad() {
        userDB.addUser(user1);
        userDB.modifyUser(user2);
    }

    @Test
    public void testDeleteUserGood() {
        userDB.addUser(user1);
        assertEquals(false, userDB.getAllUser().isEmpty());
        assertEquals(user1, userDB.deleteUser(user1));
        assertEquals(true, userDB.getAllUser().isEmpty());

    }

    @Test(expected = UserDBNotFoundException.class)
    public void testDeleteUserBad() {
        userDB.addUser(user1);
        assertEquals(false, userDB.getAllUser().isEmpty());
        userDB.deleteUser(user2);
    }

    @Test
    public void testGetAllUser() {
        userDB.addUser(user1);
        userDB.addUser(user2);
        assertEquals(2, userDB.getAllUser().size());
        assertEquals(true, userDB.getAllUser().contains(user1));
        assertEquals(true, userDB.getAllUser().contains(user2));
    }

}
