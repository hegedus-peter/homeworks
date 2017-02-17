package xyz.codingmentor.peterhegedus11hf11jpafin.service;

import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.peterhegedus11hf11jpafin.api.CRUDActorService;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.Actor;
import xyz.codingmentor.peterhegedus11hf11jpafin.repository.ActorRepository;

/**
 *
 * @author Péter
 */
@Stateless
public class ActorService implements CRUDActorService {

    @Inject
    private ActorRepository repository;

    @Override
    public void createEntity(Actor entity) {
        repository.persist(entity);
    }

    @Override
    public Actor getEntityById(Long entityId) {
        return repository.find(entityId);
    }

    @Override
    public Actor updateEntity(Actor entity) {
        return repository.merge(entity);
    }

    @Override
    public void removeEntity(Long entityId) {
        repository.remove(entityId);
    }

    @PreDestroy
    public void close() {
        repository.close();
    }

}
