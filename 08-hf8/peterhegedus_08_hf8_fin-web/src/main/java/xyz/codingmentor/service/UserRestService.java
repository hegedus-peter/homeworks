package xyz.codingmentor.service;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.entity.UserEntity;
import xyz.codingmentor.singleton.UserSingleton;

/**
 *
 * @author Péter
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserRestService {

    //http://localhost:8080/peterhegedus_08_hf8_fin-web/rest/users 
    @GET
    public List<UserEntity> getAllUsers() {
        return UserSingleton.INSTANCE.getAllUsers();
    }

    //http://localhost:8080/peterhegedus_08_hf8_fin-web/rest/users body: {"password": "123", "email": "john@john.com", "address": "1234 Budapest, Valami utca 1."}
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public UserEntity addUser(UserEntity user) {
        return UserSingleton.INSTANCE.addUser(user);
    }

    //http://localhost:8080/peterhegedus_08_hf8_fin-web/rest/users/{example: id from the return statement of post}
    @GET
    @Path("/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    public UserEntity getUser(@PathParam("id") String id) {
        return UserSingleton.INSTANCE.getUser(id);
    }

    //http://localhost:8080/peterhegedus_08_hf8_fin-web/rest/users/{example: id from the return statement of post}  body: json from the return statement of post
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public UserEntity modifyUser(@PathParam("id") String pathId, UserEntity user) {
        return UserSingleton.INSTANCE.modifyUser(pathId, user);
    }

    //http://localhost:8080/peterhegedus_08_hf8_fin-web/rest/users/{example: id from the return statement of post}
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    public UserEntity deleteUser(@PathParam("id") String id) {
        return UserSingleton.INSTANCE.deleteUser(id);
    }

}
