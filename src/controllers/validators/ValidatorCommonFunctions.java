package controllers.validators;

public class ValidatorCommonFunctions {

	/**
	 * This method is used to verify if specified argument is {@code null}; if so it
	 * raises an exception.
	 *
	 * @param arg0
	 *            - Represents an {@code Object}.
	 * @return A {@code boolean} value.
	 */
	public static boolean isNull(Object arg0) {
		return (arg0 == null);
	}

	/**
	 * This method is used to verify if specified argument is empty or null; if so
	 * it raises an exception.
	 *
	 * @param arg0
	 *            - Represents a {@code String} object.
	 * @return A {@code boolean} value.
	 */
	public static boolean isEmpty(String arg0) {
		return (arg0.isEmpty());
	}

	/**
	 * This method is used to verify if specified {@code String} object is made up
	 * of letters only.
	 *
	 * @param arg0
	 *            - Represents a {@code String} object.
	 * @return A {@code boolean} value.
	 */
	public static boolean isStringOfLetters(String arg0) {
		char[] chars = arg0.toCharArray();

		for (char c : chars)
			if (!(c >= 65 && c <= 90) && (!(c >= 97 && c <= 122) && !(c == 32)))
				return false;

		return true;
	}

	/**
	 * This method is used to verify if specified {@code String} object is made up
	 * of numbers only.
	 *
	 * @param arg0
	 *            - Represents a {@code String} object.
	 * @return A {@code boolean} value.
	 */
	public static boolean isStringOfNumbers(String arg0) {
		char[] chars = arg0.toCharArray();

		for (char c : chars)
			if (!(c >= 48 && c <= 57))
				return false;

		return true;
	}

	/**
	 * This method is used to verify if specified {@code String} object has a length
	 * less than a specified quantity.
	 * 
	 * @param arg0
	 *            - Represents a {@code String} object.
	 * @param maxLenght
	 *            - Represents an {@code int}.
	 * @return A {@code boolean} value.
	 */
	public static boolean isLengthLessThan(String arg0, int maxLenght) {
		return arg0.length() > maxLenght;
	}

	/**
	 * This method is used to verify if specified {@code String} object has a length
	 * grater than a specified quantity.
	 * 
	 * @param arg0
	 *            - Represents a {@code String} object.
	 * @param minLenght
	 *            - Represents an {@code int}.
	 * @return A {@code boolean} value.
	 */
	public static boolean isLengthGreaterThan(String arg0, int minLenght) {
		return arg0.length() < minLenght;
	}
}
