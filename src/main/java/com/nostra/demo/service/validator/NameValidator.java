package com.nostra.demo.service.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.nostra.demo.service.validator.annotation.ValidName;

@Component
public class NameValidator implements ConstraintValidator<ValidName, String> {

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		
		return !name.equalsIgnoreCase("Hatta");
	}

}
