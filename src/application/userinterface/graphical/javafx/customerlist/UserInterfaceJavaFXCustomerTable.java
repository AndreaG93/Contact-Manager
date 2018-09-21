package application.userinterface.graphical.javafx.customerlist;

import application.entity.customer.Customer;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class UserInterfaceJavaFXCustomerTable extends TableView<Customer> {

	public UserInterfaceJavaFXCustomerTable() {

		TableColumn<Customer, String> idColumn = new TableColumn<>("ID");
		TableColumn<Customer, String> titleColumn = new TableColumn<>("Titolo");
		TableColumn<Customer, String> nameColumn = new TableColumn<>("Nome");
		TableColumn<Customer, String> surnameColumn = new TableColumn<>("Cognome");
		TableColumn<Customer, String> genderColumn = new TableColumn<>("Genere");

		
		idColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(final CellDataFeatures<Customer, String> param) {
						return new ObservableValue<String>() {

							@Override
							public void addListener(InvalidationListener arg0) {
							}

							@Override
							public void removeListener(InvalidationListener arg0) {
							}

							@Override
							public void addListener(ChangeListener<? super String> listener) {
							}

							@Override
							public String getValue() {
								return String.valueOf(param.getValue().getId());
							}

							@Override
							public void removeListener(ChangeListener<? super String> listener) {
							}
						};
					}
				});
		
		nameColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(final CellDataFeatures<Customer, String> param) {
						return new ObservableValue<String>() {

							@Override
							public void addListener(InvalidationListener arg0) {
							}

							@Override
							public void removeListener(InvalidationListener arg0) {
							}

							@Override
							public void addListener(ChangeListener<? super String> listener) {
							}

							@Override
							public String getValue() {
								return param.getValue().getName();
							}

							@Override
							public void removeListener(ChangeListener<? super String> listener) {
							}
						};
					}
				});
		
		surnameColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(final CellDataFeatures<Customer, String> param) {
						return new ObservableValue<String>() {

							@Override
							public void addListener(InvalidationListener arg0) {
							}

							@Override
							public void removeListener(InvalidationListener arg0) {
							}

							@Override
							public void addListener(ChangeListener<? super String> listener) {
							}

							@Override
							public String getValue() {
								return param.getValue().getSurname();
							}

							@Override
							public void removeListener(ChangeListener<? super String> listener) {
							}
						};
					}
				});
		
		titleColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(final CellDataFeatures<Customer, String> param) {
						return new ObservableValue<String>() {

							@Override
							public void addListener(InvalidationListener arg0) {
							}

							@Override
							public void removeListener(InvalidationListener arg0) {
							}

							@Override
							public void addListener(ChangeListener<? super String> listener) {
							}

							@Override
							public String getValue() {
								return param.getValue().getTitle().toString();
							}

							@Override
							public void removeListener(ChangeListener<? super String> listener) {
							}
						};
					}
				});
		
		genderColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(final CellDataFeatures<Customer, String> param) {
						return new ObservableValue<String>() {

							@Override
							public void addListener(InvalidationListener arg0) {
							}

							@Override
							public void removeListener(InvalidationListener arg0) {
							}

							@Override
							public void addListener(ChangeListener<? super String> listener) {
							}

							@Override
							public String getValue() {
								return param.getValue().getGender().toString();
							}

							@Override
							public void removeListener(ChangeListener<? super String> listener) {
							}
						};
					}
				});
		
		this.getColumns().add(idColumn);
		this.getColumns().add(nameColumn);
		this.getColumns().add(surnameColumn);
		this.getColumns().add(titleColumn);
		this.getColumns().add(genderColumn);
	}
}