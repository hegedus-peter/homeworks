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
import xyz.codingmentor.model.Category;

/**
 *
 * @author Péter
 */
@Path("categories")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {

    private CRUDService<Category> categoryService;

    public CategoryResource() {
        //generated
    }

    @Inject
    public CategoryResource(@CRUDSpecificationAnnotation(EntityModel.CATEGORY) CRUDService<Category> categoryService) {
        this.categoryService = categoryService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCategory(Category category) {
        categoryService.createEntity(category);
        return Response.ok(category).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCategory(Category category) {
        categoryService.updateEntity(category);
        return Response.ok(category).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeCategory(@PathParam("id") Long id) {
        categoryService.removeEntity(id);
        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    public Response getCategoryById(@PathParam("id") Long id) {
        return Response.ok(categoryService.getEntityById(id)).build();
    }

}
