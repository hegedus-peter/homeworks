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
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.singleton.DeviceDB;

/**
 *
 * @author Péter
 */
@Path("/devices")
@SessionScoped
public class DeviceRESTService implements Serializable {

    public static final String USER_KEY = "user";

    @Inject
    private DeviceDB deviceDB;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO addDevice(@Context HttpServletRequest request, Device device) {
        HttpSession session = request.getSession();
        if (IsLoggedInUtility.isLoggedIn(session).isAdmin()) {
            return new ResultDTO(SUCCESS, deviceDB.addDevice(device));
        }
        return new ResultDTO(ERROR, device);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ResultDTO deleteDevice(@Context HttpServletRequest request, @PathParam("id") String id) {
        HttpSession session = request.getSession();
        Device deletedDevice = deviceDB.getDevice(id);
        if (IsLoggedInUtility.isLoggedIn(session).isAdmin()) {
            return new ResultDTO(SUCCESS, deviceDB.deleteDevice(deletedDevice));
        }
        return new ResultDTO(ERROR, deletedDevice);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ResultDTO getDevice(@PathParam("id") String id) {
        return new ResultDTO(SUCCESS, deviceDB.getDevice(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO getAllDevice() {
        return new ResultDTO(SUCCESS, deviceDB.getAllDevice());
    }

}
