package utils.actions;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import play.mvc.With;

/**
 * Annotation Interface which binds the request intercepter Action
 * {@link BasicAuthAction} to every controller method which is annotated
 * with {@link BasicAuth}.
 * 
 * Verifying basic HTTP authentication and user permissions.
 * 
 * @author cbi
 */
@With(BasicAuthAction.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
@Documented
public @interface BasicAuth {
}