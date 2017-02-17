package xyz.codingmentor.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.api.CRUDRepoAnnotation;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Category;

/**
 *
 * @author Péter
 */
@Stateless
@CRUDRepoAnnotation(EntityModel.CATEGORY)
public class CategoryRepository extends AbstractCRUDRepository<Category> implements CRUDRepository<Category> {

    @PersistenceContext(unitName = "movieServicePU")
    private EntityManager entityManager;

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
