package xyz.codingmentor.war;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDSpecificationAnnotation;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Trailer;

/**
 *
 * @author Péter
 */
@Path("trailers")
@Produces(MediaType.APPLICATION_JSON)
public class TrailerResource {

    private CRUDService<Trailer> trailerService;

    public TrailerResource() {
        //generated
    }

    @Inject
    public TrailerResource(@CRUDSpecificationAnnotation(EntityModel.TRAILER) CRUDService<Trailer> trailerService) {
        this.trailerService = trailerService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrailer(Trailer trailer) {
        trailerService.createEntity(trailer);
        return Response.ok(trailer).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTrailer(Trailer trailer) {
        trailerService.updateEntity(trailer);
        return Response.ok(trailer).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeTrailer(@PathParam("id") Long id) {
        trailerService.removeEntity(id);
        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    public Response getTrailerById(@PathParam("id") Long id) {
        return Response.ok(trailerService.getEntityById(id)).build();
    }

}
