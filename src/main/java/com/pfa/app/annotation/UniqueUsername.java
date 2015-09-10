package com.pfa.app.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.validation.Constraint;
import javax.validation.Payload;
/**
 * 
 * @author hicham-pc
 *
 */
@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { UniqueUsernameValidator.class })

public @interface UniqueUsername {
	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
