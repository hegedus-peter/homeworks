package xyz.codingmentor.service;

import xyz.codingmentor.api.CRUDRepository;

/**
 *
 * @author Péter
 */
public class GeneralCRUDService<T> {

    private final CRUDRepository<T> repository;

    public GeneralCRUDService(CRUDRepository<T> repository) {
        this.repository = repository;
    }

    public void createEntity(T entity) {
        repository.persist(entity);
    }

    public T getEntityById(Long entityId) {
        return repository.find(entityId);
    }

    public T updateEntity(T entity) {
        return repository.merge(entity);
    }

    public void removeEntity(Long entityId) {
        repository.remove(entityId);
    }

}
