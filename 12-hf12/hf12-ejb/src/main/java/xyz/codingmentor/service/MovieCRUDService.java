package xyz.codingmentor.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.api.CRUDRepoAnnotation;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDSpecificationAnnotation;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Movie;

/**
 *
 * @author Péter
 */
@Stateless
@CRUDSpecificationAnnotation(EntityModel.MOVIE)
public class MovieCRUDService extends GeneralCRUDService<Movie> implements CRUDService<Movie> {

    public MovieCRUDService() {
        super(null);
    }

    @Inject
    public MovieCRUDService(@CRUDRepoAnnotation(EntityModel.MOVIE) CRUDRepository<Movie> repository) {
        super(repository);
    }

}
