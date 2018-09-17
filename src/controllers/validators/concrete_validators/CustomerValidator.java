package controllers.validators.concrete_validators;

import controllers.validators.Validator;
import controllers.validators.ValidatorCommonFunctions;
import entity.customer.Customer;

public class CustomerValidator implements Validator {

	@Override
	public void validate(Object obj) throws Exception {

		Customer customer = (Customer) obj;

		/* Checking "null"... */
		if (ValidatorCommonFunctions.isNull(customer.getTitle()))
			throw new Exception("dsd");
		if (ValidatorCommonFunctions.isNull(customer.getName()))
			throw new Exception("");
		if (ValidatorCommonFunctions.isNull(customer.getSurname()))
			throw new Exception("");

		/* Checking "Empty"... */
		if (ValidatorCommonFunctions.isEmpty(customer.getName()))
			throw new Exception("");
		if (ValidatorCommonFunctions.isEmpty(customer.getSurname()))
			throw new Exception("");

		/* Checking only letter string... */
		if (!ValidatorCommonFunctions.isStringOfLetters(customer.getName()))
			throw new Exception("");
		if (!ValidatorCommonFunctions.isStringOfLetters(customer.getSurname()))
			throw new Exception("");

		/* Checking "lenght less than"... */
		if (ValidatorCommonFunctions.isLengthLessThan(customer.getName(), 64))
			throw new Exception("");
		if (ValidatorCommonFunctions.isLengthLessThan(customer.getSurname(), 64))
			throw new Exception("");

	}

}
