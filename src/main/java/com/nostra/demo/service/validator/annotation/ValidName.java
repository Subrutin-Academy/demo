package com.nostra.demo.service.validator.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.nostra.demo.service.validator.NameValidator;

@Constraint(validatedBy = NameValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface ValidName {
	
	String message() default "hatta is not valid name"; 
	
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};	
	

}
