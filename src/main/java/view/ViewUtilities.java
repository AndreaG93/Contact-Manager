package view;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

/**
 * This class is used to containing some useful functions.
 * 
 * @author andrea
 */
public class ViewUtilities {

	/**
	 * This method is used to display n exit confirmation {@code Alert} object.
	 * 
	 * @return A {boolean} representing user input.
	 */
	public static boolean showExitConfirmationMessage() {
		return ViewUtilities.showConfirmationMessage("You want to exit?");
	}

	/**
	 * This method is used to show a confirmation type {@code Alert} object.
	 * 
	 * @param arg1
	 *            - Represents a {@code String} object.
	 * @return A {boolean} representing user input.
	 */
	public static boolean showConfirmationMessage(String message) {

		/* Allocate a new JavaFX "Alert" object */
		Alert alert = new Alert(AlertType.CONFIRMATION);

		/* Setting up "Alert" object */
		alert.setHeaderText(message);

		/* Return user input */
		if (alert.showAndWait().get() == ButtonType.OK)
			return true;
		else
			return false;
	}

	/**
	 * This method is used to show a message type {@code Alert} object.
	 * 
	 * @param arg1
	 *            - Represents a {@code String} object.
	 */
	public static void showMessage(String message, Alert.AlertType messageType) {

		/* Allocate a new JavaFX "Alert" object */
		Alert alert = new Alert(messageType);

		/* Setting up "Alert" object */
		alert.setHeaderText(message);

		/* Show alert... */
		alert.show();
	}
}
