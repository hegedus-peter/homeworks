package xyz.codingmentor.peterhegedus03hf3confusing.source;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Péter
 */
public class ConfusingAnalyzer {

    private static final Logger LOGGER = Logger.getAnonymousLogger();
    private static final List<Method> Methods=new ArrayList<>();
    private static final List<Field> Fields=new ArrayList<>();

    private ConfusingAnalyzer(){
        
    }
    
    public static void analyze(final Class<?> clazz) {
       getConfusingFields(clazz, Confusing.class);
       getConfusingMethods(clazz, Confusing.class);
       
       for(Field field:Fields){
            addConfusingField(field);
       }
       
        for(Method method:Methods){
            addConfusingMethod(method);
       }
       
    }

    public static void getConfusingFields(final Class<?> clazz, Class<? extends Annotation> confusing) {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(confusing)) {
                Fields.add(field);
            }
        }
    }

    public static void getConfusingMethods(final Class<?> clazz, Class<? extends Annotation> confusing) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(confusing)) {
                Methods.add(method);
            }
        }
    }
    
    public static void addConfusingField(Field field) {
        LOGGER.log(Level.INFO, "Name: {0} Type: {1}", new Object[]{field.getName(), field.getType()});
    }

    public static void addConfusingMethod(Method method) {
       LOGGER.log(Level.INFO, "Name: {0} Return type: {1} Parameters: {2}", new Object[]{method.getName(), method.getReturnType(), Arrays.toString(method.getParameterTypes())});
    }

}
