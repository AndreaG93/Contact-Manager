package application;

import application.gui.javafx.gui.customerlist.UserInterfaceJavaFXCustomerList;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This class is used as application entry point.
 * 
 * @author Andrea Graziani
 * @version 1.0
 */
public class ApplicationEntryPoint extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
	
		try {
			
			new UserInterfaceJavaFXCustomerList().showUserInterface();
			
		} catch (Exception e) {
		
			e.printStackTrace();
			System.exit(1);
		}		
	}
	
	/**
	 * Application entry point.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}