package application.userinterface.javafx.customerlist;

import application.userinterface.annotation.RepresentableData;
import application.entity.customer.Customer;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.lang.reflect.Method;
import java.util.Arrays;

public class UserInterfaceJavaFXCustomerTable extends TableView<Customer> {

	public UserInterfaceJavaFXCustomerTable() {

		for (Method mMethod : Arrays.asList((Customer.class.getDeclaredMethods()))) {
			RepresentableData mRepresentableData = mMethod.getAnnotation(RepresentableData.class);
			if (mRepresentableData != null) {

				// Creating new column...
				TableColumn<Customer, String> mColumn = new TableColumn<>(mRepresentableData.description());



				mColumn.setCellValueFactory(
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

										try {
											return (String) mMethod.invoke(param.getValue(), null);
										} catch (Exception e) {
											e.printStackTrace();
											return "";
										}
									}

									@Override
									public void removeListener(ChangeListener<? super String> listener) {
									}
								};
							}
						});

				mColumn.setCellFactory(new Callback<TableColumn<Customer, String>, TableCell<Customer, String>>() {
					@Override
					public TableCell<Customer, String> call(TableColumn<Customer, String> param) {
						return new TableCell<Customer, String>(){

							@Override
							public void updateItem(String item, boolean empty) {
								super.updateItem(item, empty);
								if (!isEmpty()) {
									this.setTextFill(Color.RED);
									// Get fancy and change color based on data
									if (item.contains("@"))
										this.setTextFill(Color.BLUEVIOLET);
									setText(item);
								}
							}

						};
					}
				});


				this.getColumns().add(mColumn);
			}
		}


	}
}