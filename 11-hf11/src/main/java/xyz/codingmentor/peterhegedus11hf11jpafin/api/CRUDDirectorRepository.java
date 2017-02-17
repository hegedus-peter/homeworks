package xyz.codingmentor.peterhegedus11hf11jpafin.api;

import xyz.codingmentor.peterhegedus11hf11jpafin.model.Director;

/**
 *
 * @author Péter
 */
public interface CRUDDirectorRepository {

    void persist(Director entity);

    Director find(Long entityId);

    Director merge(Director entity);

    void remove(Long entityId);

}
