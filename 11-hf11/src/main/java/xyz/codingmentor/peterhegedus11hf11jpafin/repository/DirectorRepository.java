package xyz.codingmentor.peterhegedus11hf11jpafin.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import xyz.codingmentor.peterhegedus11hf11jpafin.api.CRUDDirectorRepository;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.Director;

/**
 *
 * @author Péter
 */
@Stateless
public class DirectorRepository implements CRUDDirectorRepository {

    private final EntityManagerFactory factory;
    private final EntityManager entityManager;

    public DirectorRepository() {
        factory = Persistence.createEntityManagerFactory("hf11PU");
        entityManager = factory.createEntityManager();
    }

    @Override
    public void persist(Director entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(entity);
        tx.commit();
    }

    @Override
    public Director find(Long entityId) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Director actDirector = entityManager.find(Director.class, entityId);
        tx.commit();
        return actDirector;
    }

    @Override
    public Director merge(Director entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Director actDirector = entityManager.merge(entity);
        tx.commit();
        return actDirector;
    }

    @Override
    public void remove(Long entityId) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(entityId);
        tx.commit();
    }

    public void close() {
        entityManager.close();
        factory.close();
    }

}
