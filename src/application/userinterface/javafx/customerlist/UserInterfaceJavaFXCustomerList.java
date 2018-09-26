package application.userinterface.javafx.customerlist;


import application.entity.customer.Customer;
import application.logic.CustomerManager;
import application.userinterface.javafx.UserInterfaceJavaFX;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Pagination;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;

public class UserInterfaceJavaFXCustomerList extends UserInterfaceJavaFX {
	
	private static final byte PAGE_SIZE = 25;
	private UserInterfaceJavaFXCustomerTable customerTable;
	@FXML
	private Pagination pgn_cutomer;
	@FXML
	private Button btn_ok;
	@FXML
	private Button btn_edit;
	@FXML
	private Button btn_delete;
	@FXML
	private Button btn_new_customer;
	@FXML
	private ImageView imgvw_edit;
	@FXML
	private ImageView imgvw_delete;
	@FXML
	private ImageView imgvw_new_customer;

	/**
	 * Constructs a newly allocated {@code ViewListCustomer} object.
	 * 
	 * @param customerManager
	 *            - Represents a {@code CustomerManager} object.
	 * @throws Exception
	 */
	public UserInterfaceJavaFXCustomerList() throws Exception {
		
		super();
		
		this.customerTable = new UserInterfaceJavaFXCustomerTable();
		

		/* Setting up button's icons. */
		this.imgvw_new_customer.setImage(new Image("file:resource/default_icon.png"));
		this.imgvw_edit.setImage(new Image("file:resource/default_icon.png"));
		this.imgvw_delete.setImage(new Image("file:resource/default_icon.png"));

		/* Disable "Edit" and "Remove" button when any "TableView"'s row is selected. */
		this.customerTable.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<Customer>() {

			@Override
			public void onChanged(Change<? extends Customer> c) {
				if (customerTable.getSelectionModel().getSelectedItems().isEmpty()) {
					btn_edit.setDisable(true);
					btn_delete.setDisable(true);
				} else {
					btn_edit.setDisable(false);
					btn_delete.setDisable(false);
				}
			}
		});
		updateUserInterface();
	}
	
	
	@Override
	public void updateUserInterface() {

		// Update page count...
		long dataCount = CustomerManager.getPersistenceSystem().getCount();
		
		System.out.println(dataCount);
		
		
		
		int pageCount = (int) (CustomerManager.getPersistenceSystem().getCount() / PAGE_SIZE);

		if ((int) CustomerManager.getPersistenceSystem().getCount() % PAGE_SIZE != 0)
			pageCount++;

		this.pgn_cutomer.setPageCount(pageCount);

		/*
		 * Setting up "Pagination"'s "PageFactory" to display a "TableView" as content
		 * of current pagination.
		 */
		this.pgn_cutomer.setPageFactory(new Callback<Integer, Node>() {

			@Override
			public Node call(Integer param) {

				// Retrieve data...
				customerTable.setItems(FXCollections
						.observableArrayList(CustomerManager.getPersistenceSystem().getPageableCollection(PAGE_SIZE, param)));
				// Return table...
				return customerTable;
			}
		});
	}

	@Override
	public void closeUserInterface() {
		stage.close();
	}

	@Override
	public void showUserInterface() {
		
		this.stage = new Stage();
		this.scene = new Scene(this.root);

		this.stage.setTitle("Home");
		this.stage.setScene(this.scene);
		this.stage.setResizable(true);

		this.stage.show();
	}

	
	
	
	/**
	 * This method is used to add a new {@code Customer} object.
	 * 
	 * @param event
	 *            - Represents a {@code ActionEvent} object.
	 */
	@FXML
	void OnAction_newCustomer(ActionEvent event) {
		/*
		try {
			// Allocate a new "ViewCreateOrEditCustomer" object.
			ViewCreateOrEditCustomer view = new ViewCreateOrEditCustomer(this.customerManager);

			// Setting up observer and show view. 
			view.addObserver(this);
			view.show();

		} catch (Exception e) {
			// Display appevent message 
			ViewUtilities.showMessage(e.getMessage(), Alert.AlertType.ERROR);
			return;
		}
		 */
	}

	/**
	 * This method is used to edit an existing {@code Customer} object.
	 * 
	 * @param event
	 *            - Represents a {@code ActionEvent} object.
	 */
	@FXML
	void OnAction_edit(ActionEvent event) {
		/*
		// Get selected "Customer" object.
		Customer selectedCustomer = this.myCustomerTable.getSelectionModel().getSelectedItem();

		// Open edit view. 
		try {

			// Allocate a new "ViewCreateOrEditCustomer" object.
			ViewCreateOrEditCustomer view = new ViewCreateOrEditCustomer(this.customerManager, selectedCustomer);

			// Setting up observer and show view. 
			view.addObserver(this);
			view.show();

		} catch (Exception e) {

			ViewUtilities.showMessage(e.getMessage(), Alert.AlertType.ERROR);
			return;
		}
		 */
	}

	/**
	 * This method is used to delete an existing {@code Customer} object.
	 * 
	 * @param event
	 *            - Represents a {@code ActionEvent} object.
	 */
	@FXML
	void OnAction_delete(ActionEvent event) {

		// Get selected 'Customer' object...
		Customer mCustomer = this.customerTable.getSelectionModel().getSelectedItem();

		// Display 'Alert' object...	
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Vuoi eliminare il cliente selezionato?\nL'operazione non può essere annullata");
		if (alert.showAndWait().get() == ButtonType.OK)
			CustomerManager.getPersistenceSystem().delete(mCustomer);
		else
			return;
	}

	/**
	 * This method is used to close current view.
	 * 
	 * @param event
	 *            - Represents a {@code ActionEvent} object.
	 */
	@FXML
	void OnAction_ok(ActionEvent event) {
		this.closeUserInterface();
	}
}
