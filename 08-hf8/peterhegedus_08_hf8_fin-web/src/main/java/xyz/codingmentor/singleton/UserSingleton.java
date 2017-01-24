package xyz.codingmentor.singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import xyz.codingmentor.entity.UserEntity;
import xyz.codingmentor.exception.UserIdNotMatchException;
import xyz.codingmentor.exception.UserNotFoundException;

/**
 *
 * @author Péter
 */
public enum UserSingleton {
    INSTANCE;
    
    private final Map<String, UserEntity> users = new HashMap<>();
    
    public List<UserEntity> getAllUsers(){
        return new ArrayList<>(users.values());
    }
    
    public UserEntity addUser(UserEntity user){
        user.setId(UUID.randomUUID().toString());
        users.put(user.getId(), user);
        return user;
    }
    
    public UserEntity getUser(String id){
        if (users.containsKey(id)) {
            return users.get(id);
        } else {
            throw new UserNotFoundException(id);
        }
    }
    
    public UserEntity modifyUser(String pathId, UserEntity user) {
        if (pathId.equals(user.getId())) {
            if (users.containsKey(pathId)) {
                 users.put(pathId, user);
                 return user;
            } else {
                throw new UserNotFoundException(pathId);
            }
        } else {
            throw new UserIdNotMatchException("The two IDs dont match: " + user.getId() + " " + pathId);
        }
    }
    
     public UserEntity deleteUser(String id) {
        if (users.containsKey(id)) {
            UserEntity deletedUser = users.get(id);
            users.remove(id);
            return deletedUser;
        } else {
            throw new UserNotFoundException(id);
        }
     }

}
