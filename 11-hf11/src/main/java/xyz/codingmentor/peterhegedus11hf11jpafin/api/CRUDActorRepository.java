package xyz.codingmentor.peterhegedus11hf11jpafin.api;

import xyz.codingmentor.peterhegedus11hf11jpafin.model.Actor;

/**
 *
 * @author Péter
 */
public interface CRUDActorRepository {

    void persist(Actor entity);

    Actor find(Long entityId);

    Actor merge(Actor entity);

    void remove(Long entityId);

}
