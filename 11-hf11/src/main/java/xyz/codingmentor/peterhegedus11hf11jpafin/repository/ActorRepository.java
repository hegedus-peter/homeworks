package xyz.codingmentor.peterhegedus11hf11jpafin.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import xyz.codingmentor.peterhegedus11hf11jpafin.api.CRUDActorRepository;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.Actor;

/**
 *
 * @author Péter
 */
@Stateless
public class ActorRepository implements CRUDActorRepository {

    private final EntityManagerFactory factory;
    private final EntityManager entityManager;

    public ActorRepository() {
        factory = Persistence.createEntityManagerFactory("hf11PU");
        entityManager = factory.createEntityManager();
    }

    @Override
    public void persist(Actor entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(entity);
        tx.commit();
    }

    @Override
    public Actor find(Long entityId) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Actor actActor = entityManager.find(Actor.class, entityId);
        tx.commit();
        return actActor;
    }

    @Override
    public Actor merge(Actor entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Actor actActor = entityManager.merge(entity);
        tx.commit();
        return actActor;
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
