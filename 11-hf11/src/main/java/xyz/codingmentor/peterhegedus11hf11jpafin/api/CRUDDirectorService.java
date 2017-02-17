package xyz.codingmentor.peterhegedus11hf11jpafin.api;

import xyz.codingmentor.peterhegedus11hf11jpafin.model.Director;

/**
 *
 * @author Péter
 */
public interface CRUDDirectorService {

    void createEntity(Director entity);

    Director getEntityById(Long entityId);

    Director updateEntity(Director entity);

    void removeEntity(Long entityId);

}
