package view.customer_list;

import java.text.MessageFormat;
import controllers.entity_managers.CustomerManager;
import entity.customer.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import view.View;
import view.ViewObserver;
import view.ViewUtilities;
import view.customer_edit.ViewCreateOrEditCustomer;
import view.customer_table.ViewCustomerTable;

public class ViewListCustomer extends View implements ViewObserver {

	/**
	 * FXML fields
	 */
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
	 * Fields
	 */
	private static final byte PAGE_SIZE = 25;
	private CustomerManager customerManager;
	private TableView<Customer> myCustomerTable;

	/**
	 * This method is used to add a new {@code Customer} object.
	 * 
	 * @param event
	 *            - Represents a {@code ActionEvent} object.
	 */
	@FXML
	void OnAction_newCustomer(ActionEvent event) {
		try {
			/* Allocate a new "ViewCreateOrEditCustomer" object. */
			ViewCreateOrEditCustomer view = new ViewCreateOrEditCustomer(this.customerManager);

			/* Setting up observer and show view. */
			view.addObserver(this);
			view.show();
			
		} catch (Exception e) {
			/* Display error message */
			ViewUtilities.showMessage(e.getMessage(), Alert.AlertType.ERROR);
			return;
		}
	}

	/**
	 * This method is used to edit an existing {@code Customer} object.
	 * 
	 * @param event
	 *            - Represents a {@code ActionEvent} object.
	 */
	@FXML
	void OnAction_edit(ActionEvent event) {

		/* Get selected "Customer" object. */
		Customer selectedCustomer = this.myCustomerTable.getSelectionModel().getSelectedItem();

		/* Open edit view. */
		try {

			/* Allocate a new "ViewCreateOrEditCustomer" object. */
			ViewCreateOrEditCustomer view = new ViewCreateOrEditCustomer(this.customerManager, selectedCustomer);
			
			/* Setting up observer and show view. */
			view.addObserver(this);
			view.show();
			
		} catch (Exception e) {
			/* Display error message */
			ViewUtilities.showMessage(e.getMessage(), Alert.AlertType.ERROR);
			return;
		}
	}

	/**
	 * This method is used to delete an existing {@code Customer} object.
	 * 
	 * @param event
	 *            - Represents a {@code ActionEvent} object.
	 */
	@FXML
	void OnAction_delete(ActionEvent event) {

		/* Get selected "Customer" object. */
		Customer selectedCustomer = this.myCustomerTable.getSelectionModel().getSelectedItem();

		/* Generation message. */
		String message = MessageFormat.format("Vuoi eliminare il cliente {0}", selectedCustomer.getName());

		/* Deleting and update view. */
		if (ViewUtilities.showConfirmationMessage(message)) {
			this.customerManager.deleteCustomer(selectedCustomer);
			updateView();
		}
	}

	/**
	 * This method is used to close current view.
	 * 
	 * @param event
	 *            - Represents a {@code ActionEvent} object.
	 */
	@FXML
	void OnAction_ok(ActionEvent event) {
		this.close();
	}

	/**
	 * Constructs a newly allocated {@code ViewListCustomer} object.
	 * 
	 * @param customerManager
	 *            - Represents a {@code CustomerManager} object.
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ViewListCustomer(CustomerManager arg0) throws Exception {
		super();

		/* Getting a "CustomerManager" instance to manage "Customer" objects. */
		this.customerManager = arg0;

		/* Adding a "TableView" allcating a new "ViewCustomerTable" object. */
		ViewCustomerTable viewObj = new ViewCustomerTable();
		this.myCustomerTable = (TableView<Customer>) viewObj.getRoot();

		/* Setting up button's icons. */
		this.imgvw_new_customer.setImage(new Image("file:resource/default_icon.png"));
		this.imgvw_edit.setImage(new Image("file:resource/default_icon.png"));
		this.imgvw_delete.setImage(new Image("file:resource/default_icon.png"));

		/* Disable "Edit" and "Remove" button when any "TableView"'s row is selected. */
		this.myCustomerTable.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<Customer>() {

			@Override
			public void onChanged(Change<? extends Customer> c) {
				if (myCustomerTable.getSelectionModel().getSelectedItems().isEmpty()) {
					btn_edit.setDisable(true);
					btn_delete.setDisable(true);
				} else {
					btn_edit.setDisable(false);
					btn_delete.setDisable(false);
				}
			}
		});
	}

	/**
	 * This method is used to initialize view.
	 */
	@Override
	protected void initializationView() {
		updateView();
	}

	@Override
	public void updateView() {

		/* Update "Pagination"'s "page count". */
		int pageCount = (int) customerManager.getCustomerDAO().getCount() / PAGE_SIZE;

		if ((int) customerManager.getCustomerDAO().getCount() % PAGE_SIZE != 0)
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
				myCustomerTable.setItems(FXCollections
						.observableArrayList(customerManager.getCustomerDAO().getPageableCollections(PAGE_SIZE, param)));
				// Return table...
				return myCustomerTable;
			}
		});
	}
}
