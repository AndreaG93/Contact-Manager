package application;
	
import controllers.entity_managers.CustomerManager;
import entity.customer.Customer;
import entity.customer.Title;
import entity.telephone_number.TelephoneNumber;
import javafx.application.Application;
import javafx.stage.Stage;
import test.hibernate.HibernateCustomerDAOTest;
import view.customer_list.ViewListCustomer;



public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		HibernateCustomerDAOTest.initialization();

		
		
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
