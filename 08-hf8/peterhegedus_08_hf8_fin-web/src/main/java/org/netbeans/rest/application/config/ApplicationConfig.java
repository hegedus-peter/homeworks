package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Péter
 */
@javax.ws.rs.ApplicationPath("/rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(xyz.codingmentor.exception.GeneralExceptionMapper.class);
        resources.add(xyz.codingmentor.service.UserRestService.class);
    }

}
