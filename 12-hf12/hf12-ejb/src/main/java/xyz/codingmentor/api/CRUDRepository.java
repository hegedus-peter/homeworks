package xyz.codingmentor.api;

/**
 *
 * @author Péter
 */
public interface CRUDRepository<T> {

    void persist(T entity);

    T find(Long entityId);

    T merge(T entity);

    void remove(Long entityId);

}
