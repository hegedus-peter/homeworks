package xyz.codingmentor.services;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.webdto.ResultDTO;
import static xyz.codingmentor.webdto.ResultType.ERROR;
import static xyz.codingmentor.webdto.ResultType.SUCCESS;
import xyz.codingmentor.beans.UserEntity;
import xyz.codingmentor.singleton.UserDB;

/**
 *
 * @author Péter
 */
@Path("/users")
@SessionScoped
public class UserRESTService implements Serializable {

    public static final String USER_KEY = "user";

    @Inject
    private UserDB userDB;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO addUser(@Context HttpServletRequest request, UserEntity user) {
        HttpSession session = request.getSession();
        if (IsLoggedInUtility.isLoggedIn(session).isAdmin()) {
            return new ResultDTO(SUCCESS, userDB.addUser(user));
        }
        return new ResultDTO(ERROR, user);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    public ResultDTO deleteUser(@Context HttpServletRequest request, @PathParam("username") String username) {
        HttpSession session = request.getSession();
        UserEntity deletedUser = userDB.getUser(username);
        if (IsLoggedInUtility.isLoggedIn(session).isAdmin()) {
            return new ResultDTO(SUCCESS, userDB.deleteUser(deletedUser));
        }
        return new ResultDTO(ERROR, deletedUser);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    public ResultDTO getUser(@PathParam("username") String username) {
        return new ResultDTO(SUCCESS, userDB.getUser(username));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO getAllUsers() {
        return new ResultDTO(SUCCESS, userDB.getAllUser());
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO logIn(@Context HttpServletRequest request, UserEntity user) {
        if (userDB.authenticate(user.getUsername(), user.getPassword())) {
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(2000);
            session.setAttribute(USER_KEY, user);
            return new ResultDTO(SUCCESS, user);
        } else {
            return new ResultDTO(ERROR, user);
        }
    }

    @POST
    @Path("/logout")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO logOut(@Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserEntity actUser = IsLoggedInUtility.isLoggedIn(session);
        session.invalidate();
        return new ResultDTO(SUCCESS, actUser);

    }

}
