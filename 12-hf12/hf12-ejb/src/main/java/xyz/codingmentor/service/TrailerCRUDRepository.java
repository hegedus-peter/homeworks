package xyz.codingmentor.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.api.CRUDRepoAnnotation;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDSpecificationAnnotation;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Trailer;

/**
 *
 * @author Péter
 */
@Stateless
@CRUDSpecificationAnnotation(EntityModel.TRAILER)
public class TrailerCRUDRepository extends GeneralCRUDService<Trailer> implements CRUDService<Trailer> {

    public TrailerCRUDRepository() {
        super(null);
    }

    @Inject
    public TrailerCRUDRepository(@CRUDRepoAnnotation(EntityModel.TRAILER) CRUDRepository<Trailer> repository) {
        super(repository);
    }

}
