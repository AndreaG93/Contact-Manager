package application;
	
import controllers.entity_managers.CustomerManager;
import javafx.application.Application;
import javafx.stage.Stage;

import view.customer_list.ViewListCustomer;



public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		


		
		
		ViewListCustomer myListCustomer = new ViewListCustomer(new CustomerManager());
		
		myListCustomer.setWindowResizable(true);
		myListCustomer.setWindowTitle("prova");
		try {
			myListCustomer.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
