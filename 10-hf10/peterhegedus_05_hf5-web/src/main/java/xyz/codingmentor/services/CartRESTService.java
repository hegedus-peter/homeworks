package xyz.codingmentor.services;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.webdto.ResultDTO;
import static xyz.codingmentor.webdto.ResultType.ERROR;
import static xyz.codingmentor.webdto.ResultType.SUCCESS;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.cart.ShoppingCart;
import xyz.codingmentor.exception.NotLoggedInException;
import xyz.codingmentor.singleton.DeviceDB;

/**
 *
 * @author Péter
 */
@Path("/cart")
@SessionScoped
public class CartRESTService implements Serializable {

    @Inject
    private ShoppingCart cart;

    @Inject
    private DeviceDB deviceDB;

    @POST
    @Path("/add/{count}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO addDevice(@Context HttpServletRequest request, Device device, @PathParam("count") Integer count) {
        if (isLoggedIn(request)) {
            return new ResultDTO(SUCCESS, cart.addDevice(device.getId(), count));
        }
        return new ResultDTO(ERROR, device);
    }

    @DELETE
    @Path("/{id}/{count}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO removeDevice(@Context HttpServletRequest request, @PathParam("id") String id, @PathParam("count") Integer count) {
        if (isLoggedIn(request)) {
            return new ResultDTO(SUCCESS, cart.removeDevice(id, count));
        }
        return new ResultDTO(ERROR, deviceDB.getDevice(id));
    }

    @POST
    @Path("/buy")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO buy(@Context HttpServletRequest request) {
        if (isLoggedIn(request)) {
            return new ResultDTO(SUCCESS, cart.buyCart());
        }
        return new ResultDTO(ERROR, cart);
    }

    private static boolean isLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (null == session.getAttribute(UserRESTService.USER_KEY)) {
            throw new NotLoggedInException();
        } else {
            return true;
        }
    }

}
