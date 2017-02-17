package xyz.codingmentor.war;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDSpecificationAnnotation;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Category;
import xyz.codingmentor.model.Movie;
import xyz.codingmentor.service.DatabaseService;

/**
 *
 * @author Péter
 */
@Path("database")
public class DatabaseResource {

    private DatabaseService databaseService;
    private CRUDService<Movie> movieService;
    private CRUDService<Category> categoryService;

    public DatabaseResource() {
        //generated
    }

    @Inject
    public DatabaseResource(@CRUDSpecificationAnnotation(EntityModel.MOVIE) CRUDService<Movie> movieService, DatabaseService databaseService, @CRUDSpecificationAnnotation(EntityModel.CATEGORY) CRUDService<Category> categoryService) {
        this.movieService = movieService;
        this.databaseService = databaseService;
        this.categoryService = categoryService;
    }

    @GET
    @Path("movieactor/{id}")
    public Response getMovieActor(@PathParam("id") Long id) {
        Movie actMovie = movieService.getEntityById(id);
        return Response.ok(databaseService.getMovieActor(actMovie).toString()).build();
    }

    @GET
    @Path("nameactor/{firstName}/{lastName}")
    public Response getNameActor(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
        return Response.ok(databaseService.getNameActor(firstName, lastName).toString()).build();
    }

    @GET
    @Path("nationalityactor/{nationality}")
    public Response getNationalityActor(@PathParam("nationality") String nationality) {
        return Response.ok(databaseService.getNationalityActor(nationality).toString()).build();
    }

    @GET
    @Path("categorymovie/{id}")
    public Response getCategoryMovie(@PathParam("id") Long id) {
        Category actCategory = categoryService.getEntityById(id);
        return Response.ok(databaseService.getCategoryMovie(actCategory).toString()).build();
    }

    @GET
    @Path("titlemovie/{title}")
    public Response getTitleMovie(@PathParam("title") String title) {
        return Response.ok(databaseService.getTitleMovie(title).toString()).build();
    }

    @GET
    @Path("movietrailer/{id}")
    public Response getMovieTrailers(@PathParam("id") Long id) {
        Movie actMovie = movieService.getEntityById(id);
        return Response.ok(databaseService.getMovieTrailers(actMovie).toString()).build();
    }

}
