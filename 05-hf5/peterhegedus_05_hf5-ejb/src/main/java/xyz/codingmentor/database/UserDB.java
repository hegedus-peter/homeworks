package xyz.codingmentor.database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.codingmentor.beans.UserEntity;
import xyz.codingmentor.exceptions.UserDBAlreadyThereException;
import xyz.codingmentor.exceptions.UserDBNotFoundException;

/**
 *
 * @author Péter
 */
public class UserDB {

    private final Map<String, UserEntity> data;

    public UserDB() {
        data = new HashMap<>();
    }

    public UserEntity addUser(UserEntity userEntity) {
        if (!data.containsKey(userEntity.getUsername())) {
            Date currentDate = Calendar.getInstance().getTime();

            userEntity.setLastModifiedDate(currentDate);
            userEntity.setRegistrationDate(currentDate);

            data.put(userEntity.getUsername(), userEntity);

            return userEntity;
        }
        throw new UserDBAlreadyThereException(userEntity.getUsername());

    }

    public UserEntity getUser(String username) {
        if (null != data && data.containsKey(username)) {
            return data.get(username);
        }
        throw new UserDBNotFoundException(username);

    }

    public boolean authenticate(String username, String password) {
        if (null != data && data.containsKey(username) && data.get(username).getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public UserEntity modifyUser(UserEntity userEntity) {
        Date currentDate = Calendar.getInstance().getTime();
        userEntity.setLastModifiedDate(currentDate);

        if (null != data && data.containsKey(userEntity.getUsername())) {
            data.put(userEntity.getUsername(), userEntity);
            return data.get(userEntity.getUsername());
        }
        throw new UserDBNotFoundException(userEntity.getUsername());
    }

    public UserEntity deleteUser(UserEntity userEntity) {
        if (null != data && data.containsKey(userEntity.getUsername())) {
            return data.remove(userEntity.getUsername());
        }
        throw new UserDBNotFoundException(userEntity.getUsername());
    }

    public List<UserEntity> getAllUser() {
        return new ArrayList<>(data.values());
    }
}
