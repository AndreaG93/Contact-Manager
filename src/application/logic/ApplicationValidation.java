package application.logic;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;



/**
 * This class provides some functions used to perform entity validation.
 * 
 * @author Andrea Graziani
 * @version 1.0
 */
public class ApplicationValidation {

	public static <T> Set<ConstraintViolation<T>> validate(T pObject) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		return validator.validate(pObject);
	}
}
