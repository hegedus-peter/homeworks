package xyz.codingmentor.exception;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import xyz.codingmentor.webdto.ErrorDTO;

/**
 *
 * @author Péter
 */
@Provider
public class NotLoggedInExceptionMapper implements ExceptionMapper<NotLoggedInException> {

    private static final Logger LOG = Logger.getLogger(NotLoggedInExceptionMapper.class.getName());

    @Override
    public Response toResponse(NotLoggedInException exception) {
        LOG.log(Level.SEVERE, "Not logged in Exception", exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorDTO(exception.getMessage() + " - " + exception.getCause())).type(MediaType.APPLICATION_JSON).build();
    }

}
