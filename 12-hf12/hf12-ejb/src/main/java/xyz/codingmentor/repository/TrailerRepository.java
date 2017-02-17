package xyz.codingmentor.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.api.CRUDRepoAnnotation;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Trailer;

/**
 *
 * @author Péter
 */
@Stateless
@CRUDRepoAnnotation(EntityModel.TRAILER)
public class TrailerRepository extends AbstractCRUDRepository<Trailer> implements CRUDRepository<Trailer> {

    @PersistenceContext(unitName = "movieServicePU")
    private EntityManager entityManager;

    @Override
    protected Class<Trailer> getEntityClass() {
        return Trailer.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
