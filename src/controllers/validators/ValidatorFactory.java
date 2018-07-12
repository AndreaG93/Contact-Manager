package controllers.validators;

import java.text.MessageFormat;

public class ValidatorFactory {

	public static void validate(Object obj) throws Exception {
		
		Validator concreteValidator = null;
		
		/* Concrete validator's name processing... */
		String className = MessageFormat.format("{0}.concrete_validators.{1}Validator", ValidatorFactory.class.getPackage().getName(),
				obj.getClass().getSimpleName());

		/* Instantiation concrete validator... */
		try {
			concreteValidator = (Validator) Class.forName(className).newInstance();
		} catch (Exception e) {
			/* Print data about error and exit. */
			e.printStackTrace();
			System.exit(1);
		}
		
		/* Validation */
		concreteValidator.validate(obj);
	}
}
