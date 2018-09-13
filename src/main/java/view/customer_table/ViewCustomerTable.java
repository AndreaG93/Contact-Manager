package view.customer_table;

import entity.customer.Customer;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;
import view.View;

public class ViewCustomerTable extends View {

	public ViewCustomerTable() throws Exception {
		super();

		/**
		 * Setting up "Name" column...
		 */
		this.tblcl_name.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
						return new ObservableValue<String>() {

							@Override
							public void addListener(InvalidationListener arg0) {
								// TODO Auto-generated method stub

							}

							@Override
							public void removeListener(InvalidationListener arg0) {
								// TODO Auto-generated method stub

							}

							@Override
							public void addListener(ChangeListener<? super String> listener) {
								// TODO Auto-generated method stub

							}

							@Override
							public String getValue() {
								return param.getValue().getName();
							}

							@Override
							public void removeListener(ChangeListener<? super String> listener) {
								// TODO Auto-generated method stub

							}
						};
					}
				});
		
		/**
		 * Setting up "Surname" column...
		 */
		this.tblcl_surname.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
						return new ObservableValue<String>() {

							@Override
							public void addListener(InvalidationListener arg0) {
								// TODO Auto-generated method stub

							}

							@Override
							public void removeListener(InvalidationListener arg0) {
								// TODO Auto-generated method stub

							}

							@Override
							public void addListener(ChangeListener<? super String> listener) {
								// TODO Auto-generated method stub

							}

							@Override
							public String getValue() {
								return param.getValue().getSurname();
							}

							@Override
							public void removeListener(ChangeListener<? super String> listener) {
								// TODO Auto-generated method stub

							}
						};
					}
				});

	}

	@FXML
	private TableView<Customer> tbl_customer;

	@FXML
	private TableColumn<Customer, String> tblcl_name;

	@FXML
	private TableColumn<Customer, String> tblcl_surname;

	@Override
	protected void initializationView() {

		
		
	}

}
