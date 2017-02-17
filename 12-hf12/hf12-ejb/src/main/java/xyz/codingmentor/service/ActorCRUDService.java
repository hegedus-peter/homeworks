package xyz.codingmentor.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.api.CRUDRepoAnnotation;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDSpecificationAnnotation;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Actor;

/**
 *
 * @author Péter
 */
@Stateless
@CRUDSpecificationAnnotation(EntityModel.ACTOR)
public class ActorCRUDService extends GeneralCRUDService<Actor> implements CRUDService<Actor> {

    public ActorCRUDService() {
        super(null);
    }

    @Inject
    public ActorCRUDService(@CRUDRepoAnnotation(EntityModel.ACTOR) CRUDRepository<Actor> repository) {
        super(repository);
    }

}
