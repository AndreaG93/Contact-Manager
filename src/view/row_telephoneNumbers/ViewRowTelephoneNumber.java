package view.row_telephoneNumbers;

import java.util.List;

import controllers.validators.ValidatorCommonFunctions;
import entity.telephone_number.TelephoneNumber;
import entity.telephone_number.TelephoneNumberType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import view.View;

public class ViewRowTelephoneNumber extends View {

	@FXML
	private TextField txtfld_telephoneNumber;
	@FXML
	private Button btn_delete;
	@FXML
	private ComboBox<TelephoneNumberType> cmbx_telephoneType;

	private List<TelephoneNumber> telephoneNumbers;
	private TelephoneNumber telephoneNumber;

	/**
	 * Constructs a newly allocated {@code ViewRowTelephoneNumber} object.
	 * 
	 * @param arg0
	 *            - Represents a {@code TelephoneNumber} object.
	 * @param arg1
	 *            - Represents a {@code List<TelephoneNumber>} object.
	 * @throws Exception
	 */
	public ViewRowTelephoneNumber(TelephoneNumber arg0, List<TelephoneNumber> arg1) throws Exception {
		super();
		this.telephoneNumber = arg0;
		this.telephoneNumbers = arg1;

		/* Set value to "TelephoneNumberType ComboBox" */
		this.cmbx_telephoneType.getItems().setAll(TelephoneNumberType.values());

		/* Populate view. */
		this.txtfld_telephoneNumber.setText(this.telephoneNumber.getNumber());
		this.cmbx_telephoneType.setValue(this.telephoneNumber.getType());

		this.txtfld_telephoneNumber.textProperty().addListener((observable, oldValue, newValue) -> {
			
			if (ValidatorCommonFunctions.isStringOfNumbers(newValue))
				this.telephoneNumber.setNumber(newValue);
			else
				this.txtfld_telephoneNumber.setText(oldValue);
				
		});
		
		this.cmbx_telephoneType.valueProperty().addListener((observable, oldValue, newValue) -> {
			this.telephoneNumber.setType(newValue);
			
			
		});
		
		
				
				
	}

	/**
	 * This method is used to delete current {@code TelephoneNumber} object.
	 * 
	 * @param event
	 *            - Represents a {@code ActionEvent} object.
	 */
	@FXML
	void OnAction_delete(ActionEvent event) {

		/* Delete object from given list. */
		this.telephoneNumbers.remove(this.telephoneNumber);

		/* Notify to observers. */
		this.notifyToObservers();
	}

	@Override
	protected void initializationView() {
	}
}
