package xyz.codingmentor.peterhegedus11hf11jpafin.service;

import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.peterhegedus11hf11jpafin.api.CRUDDirectorService;
import xyz.codingmentor.peterhegedus11hf11jpafin.model.Director;
import xyz.codingmentor.peterhegedus11hf11jpafin.repository.DirectorRepository;

/**
 *
 * @author Péter
 */
@Stateless
public class DirectorService implements CRUDDirectorService {

    @Inject
    private DirectorRepository repository;

    @Override
    public void createEntity(Director entity) {
        repository.persist(entity);
    }

    @Override
    public Director getEntityById(Long entityId) {
        return repository.find(entityId);
    }

    @Override
    public Director updateEntity(Director entity) {
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
