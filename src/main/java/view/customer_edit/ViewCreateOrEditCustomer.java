package view.customer_edit;

import controllers.entity_managers.CustomerManager;
import entity.customer.Customer;
import entity.customer.Title;
import entity.telephone_number.TelephoneNumber;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import view.View;
import view.ViewObserver;
import view.ViewUtilities;
import view.row_telephoneNumbers.ViewRowTelephoneNumberCellFactory;

public class ViewCreateOrEditCustomer extends View implements ViewObserver {

	/**
	 * FXML fields
	 */
	@FXML
	private ComboBox<Title> cmbx_title;
	@FXML
	private TextField txtfld_name;
	@FXML
	private TextField txtfld_organization;
	@FXML
	private Label lbl_id;
	@FXML
	private TextField txtfld_surname;
	@FXML
	private TextField txtfld_tax_code;
	@FXML
	private ListView<TelephoneNumber> lstVw_telephoneNumbers;
	@FXML
	private ListView<?> lstVw_emailAddresses;
	@FXML
	private TextField txtfld_iva_code;
	@FXML
	private TextField txtfld_town;
	@FXML
	private ComboBox<?> cmbx_province;

	/**
	 * Fields
	 */
	private CustomerManager customerManager;
	private Customer customer;
	private boolean editMode;

	@FXML
	void OnAction_add_telephone_number(ActionEvent event) {
		this.customer.getTelephoneNumbers().add(new TelephoneNumber());
		updateView();
	}

	@FXML
	void OnAction_add_email_address(ActionEvent event) {
	}

	/**
	 * This method is used to cancel current session. All unsaved data will be lost.
	 * 
	 * @param event
	 *            - Represents a {@code ActionEvent} object.
	 */
	@FXML
	void OnAction_cancel(ActionEvent event) {

		if (ViewUtilities.showConfirmationMessage("Sicuro di voler uscire? Tutti i dati non salvati andranno persi."))
			this.close();
	}

	/**
	 * This method is used to validate inserted data and update database.
	 * 
	 * @param event
	 *            - Represents a {@code ActionEvent} object.
	 */
	@FXML
	void OnAction_ok(ActionEvent event) {

		/* Populate data */
		this.customer.setName(txtfld_name.getText());
		this.customer.setSurname(txtfld_surname.getText());
		this.customer.setTitle(cmbx_title.getValue());

		try {
			/* Validate inserted data, notify observers and close */
			if (editMode)
				this.customerManager.updateCustomer(this.customer);
			else
				this.customerManager.insertCustomer(this.customer);

			this.notifyToObservers();
			this.close();

		} catch (Exception e) {

			/* Display appevent message */
			ViewUtilities.showMessage(e.getMessage(), AlertType.ERROR);
			return;
		}
	}

	/**
	 * Constructs a newly allocated {@code ViewCreateOrEditCustomer} object.
	 * 
	 * @param arg0
	 *            - Represents a {@code CustomerManager} object.
	 * @throws Exception
	 */
	public ViewCreateOrEditCustomer(CustomerManager arg0) throws Exception {
		super();
		this.customerManager = arg0;
		this.customer = new Customer();
		this.editMode = false;
	}

	/**
	 * Constructs a newly allocated {@code ViewCreateOrEditCustomer} object.
	 * 
	 * @param arg0
	 *            - Represents a {@code CustomerManager} object.
	 * @param arg1
	 *            - Represents a {@code Customer} object.
	 * @throws Exception
	 */
	public ViewCreateOrEditCustomer(CustomerManager arg0, Customer arg1) throws Exception {
		super();
		this.customerManager = arg0;
		this.customer = arg1;
		this.editMode = true;
	}

	@Override
	protected void initializationView() {

		/* Set value to "Title ComboBox" */
		this.cmbx_title.getItems().setAll(Title.values());

		/* Populate fields. */
		this.lbl_id.setText(String.valueOf(this.customer.getId()));
		this.cmbx_title.setValue(this.customer.getTitle());
		this.txtfld_name.setText(this.customer.getName());
		this.txtfld_surname.setText(this.customer.getSurname());
	
		/* Update View */
		updateView();
	}

	@Override
	public void updateView() {

		/* Setting up "ListView" content. */
		this.lstVw_telephoneNumbers.setItems(FXCollections.observableList(this.customer.getTelephoneNumbers()));

		/* Setting up custom "ListView" row. */
		this.lstVw_telephoneNumbers
				.setCellFactory(new ViewRowTelephoneNumberCellFactory(this, this.customer.getTelephoneNumbers()));
	}
}
