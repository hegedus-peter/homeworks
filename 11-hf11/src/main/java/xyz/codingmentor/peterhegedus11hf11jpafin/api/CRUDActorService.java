package xyz.codingmentor.peterhegedus11hf11jpafin.api;

import xyz.codingmentor.peterhegedus11hf11jpafin.model.Actor;

/**
 *
 * @author Péter
 */
public interface CRUDActorService {

    void createEntity(Actor entity);

    Actor getEntityById(Long entityId);

    Actor updateEntity(Actor entity);

    void removeEntity(Long entityId);

}
