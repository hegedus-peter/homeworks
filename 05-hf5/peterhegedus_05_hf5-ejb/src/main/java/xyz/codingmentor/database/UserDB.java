package xyz.codingmentor.database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import xyz.codingmentor.beans.UserEntity;
import xyz.codingmentor.exceptions.UserDBException;

/**
 *
 * @author Péter
 */
public class UserDB {

    private final List<UserEntity> data;

    public UserDB() {
        data = new ArrayList<>();
    }

    public UserEntity addUser(UserEntity userEntity) {
        Date currentDate = Calendar.getInstance().getTime();

        userEntity.setLastModifiedDate(currentDate);
        userEntity.setRegistrationDate(currentDate);

        data.add(userEntity);

        return userEntity;
    }

    public UserEntity getUser(String username) {
        if (null != data) {
            for (UserEntity user : data) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
        }
        throw new UserDBException();

    }

    public boolean authenticate(String username, String password) {
        if (null != data) {
            for (UserEntity user : data) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public UserEntity modifyUser(UserEntity userEntity) {
        Date currentDate = Calendar.getInstance().getTime();
        userEntity.setLastModifiedDate(currentDate);

        if (null != data) {
            for (UserEntity user : data) {
                if (userEntity.getUsername().equals(user.getUsername())
                        && userEntity.getPassword().equals(user.getPassword())) {
                    user = userEntity;
                    return user;
                }
            }
            throw new UserDBException();
        }
        throw new UserDBException();
    }

    public UserEntity deleteUser(UserEntity userEntity) {
        UserEntity deletedUser;
        if (null != data) {
            for (UserEntity user : data) {
                if (userEntity.getUsername().equals(user.getUsername())
                        && userEntity.getPassword().equals(user.getPassword())) {
                    deletedUser = user;
                    data.remove(user);
                    return deletedUser;
                }
            }
            throw new UserDBException();
        }
        throw new UserDBException();
    }

    public List<UserEntity> getAllUser() {
        return this.data;
    }
}
