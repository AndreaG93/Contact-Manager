package view.row_telephoneNumbers;

import java.util.List;

import entity.telephone_number.TelephoneNumber;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import view.ViewObserver;

public class ViewRowTelephoneNumberCellFactory implements Callback<ListView<TelephoneNumber>, ListCell<TelephoneNumber>> {

	private ViewObserver observer;
	private List<TelephoneNumber> TelephoneNumbers;
	
	
	
	
	public ViewRowTelephoneNumberCellFactory(ViewObserver observer, List<TelephoneNumber> telephoneNumbers) {
		super();
		this.observer = observer;
		TelephoneNumbers = telephoneNumbers;
	}




	@Override
	public ListCell<TelephoneNumber> call(ListView<TelephoneNumber> param) {
		return new ViewRowTelephoneNumberAdapter(this.TelephoneNumbers, this.observer);
	}

}
