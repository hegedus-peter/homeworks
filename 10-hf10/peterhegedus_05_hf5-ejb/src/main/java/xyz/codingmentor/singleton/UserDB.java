package xyz.codingmentor.singleton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;
import javax.interceptor.ExcludeClassInterceptors;
import xyz.codingmentor.beans.UserEntity;
import xyz.codingmentor.constraint.Interceptable;
import xyz.codingmentor.exceptions.UserDBAlreadyThereException;
import xyz.codingmentor.exceptions.UserDBNotFoundException;

/**
 *
 * @author Péter
 */
@Interceptable
@Singleton
public class UserDB implements Serializable {

    private final Map<String, UserEntity> data;

    public UserDB() {
        data = new HashMap<>();
    }

    @ExcludeClassInterceptors
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
        return null != data && data.containsKey(username) && data.get(username).getPassword().equals(password);
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

    public void clear() {
        this.data.clear();
    }
}
