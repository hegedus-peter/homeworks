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
import xyz.codingmentor.model.Actor;

/**
 *
 * @author Péter
 */
@Path("actors")
@Produces(MediaType.APPLICATION_JSON)
public class ActorResource {

    private CRUDService<Actor> actorService;

    public ActorResource() {
        //generated
    }

    @Inject
    public ActorResource(@CRUDSpecificationAnnotation(EntityModel.ACTOR) CRUDService<Actor> actorService) {
        this.actorService = actorService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createActor(Actor actor) {
        actorService.createEntity(actor);
        return Response.ok(actor).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateActor(Actor actor) {
        actorService.updateEntity(actor);
        return Response.ok(actor).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeActor(@PathParam("id") Long id) {
        actorService.removeEntity(id);
        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    public Response getActorById(@PathParam("id") Long id) {
        return Response.ok(actorService.getEntityById(id)).build();
    }

}
