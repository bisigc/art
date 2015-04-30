package utils.actions;

import play.mvc.With;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation Interface which binds the request intercepter Action
 * {@link SessionAuthAction} to every controller method which is annotated
 * with {@link SessionAuth}.
 * 
 * Verifying session based login and the users permissions. 
 * 
 * @author cbi
 */
@With(SessionAuthAction.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
@Documented
public @interface SessionAuth {
}