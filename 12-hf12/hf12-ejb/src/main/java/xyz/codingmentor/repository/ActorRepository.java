package xyz.codingmentor.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.api.CRUDRepoAnnotation;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Actor;

/**
 *
 * @author Péter
 */
@Stateless
@CRUDRepoAnnotation(EntityModel.ACTOR)
public class ActorRepository extends AbstractCRUDRepository<Actor> implements CRUDRepository<Actor> {

    @PersistenceContext(unitName = "movieServicePU")
    private EntityManager entityManager;

    @Override
    protected Class<Actor> getEntityClass() {
        return Actor.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
