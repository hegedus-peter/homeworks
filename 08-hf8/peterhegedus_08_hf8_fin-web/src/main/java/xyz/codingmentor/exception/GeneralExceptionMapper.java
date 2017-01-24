package xyz.codingmentor.exception;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Péter
 */
@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Throwable>{
    
    private static final Logger LOGGER = Logger.getLogger(GeneralExceptionMapper.class.getSimpleName());

    @Override
    public Response toResponse(Throwable exception) {
        LOGGER.log(Level.SEVERE, "Exception on web service", exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                       .entity(new ErrorDTO(exception.getMessage()))
                       .type(MediaType.APPLICATION_JSON)
                       .build();
    }

}
