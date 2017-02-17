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
import xyz.codingmentor.model.Movie;
import xyz.codingmentor.model.Trailer;
import xyz.codingmentor.service.Joiner;

/**
 *
 * @author Péter
 */
@Path("movies")
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

    private CRUDService<Movie> movieService;

    private Joiner joiner;

    public MovieResource() {
        //generated
    }

    @Inject
    public MovieResource(@CRUDSpecificationAnnotation(EntityModel.MOVIE) CRUDService<Movie> movieService, Joiner manyToManyFixer) {
        this.movieService = movieService;
        this.joiner = manyToManyFixer;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMovie(Movie movie) {
        movieService.createEntity(movie);
        if (null != movie.getTrailers()) {
            for (Trailer trailer : movie.getTrailers()) {
                joiner.fixMovieTrailer(movie, trailer);
            }
        }
        if (null != movie.getActors()) {
            for (Actor actor : movie.getActors()) {
                joiner.fixMovieActor(movie, actor);
            }
        }

        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMovie(Movie movie) {
        movieService.updateEntity(movie);
        return Response.ok(movie).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeMovie(@PathParam("id") Long id) {
        movieService.removeEntity(id);
        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    public Response getMovieById(@PathParam("id") Long id) {
        return Response.ok(movieService.getEntityById(id)).build();
    }

}
