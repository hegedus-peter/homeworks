package xyz.codingmentor.api;

/**
 *
 * @author Péter
 */
public interface CRUDService<T> {

    void createEntity(T entity);

    T getEntityById(Long entityId);

    T updateEntity(T entity);

    void removeEntity(Long entityId);

}
