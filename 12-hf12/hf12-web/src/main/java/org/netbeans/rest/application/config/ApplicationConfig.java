package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Péter
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(xyz.codingmentor.war.ActorResource.class);
        resources.add(xyz.codingmentor.war.CategoryResource.class);
        resources.add(xyz.codingmentor.war.DatabaseResource.class);
        resources.add(xyz.codingmentor.war.MovieResource.class);
        resources.add(xyz.codingmentor.war.TrailerResource.class);
    }

}
