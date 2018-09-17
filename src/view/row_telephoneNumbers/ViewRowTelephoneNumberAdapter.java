package view.row_telephoneNumbers;

import java.util.List;

import entity.telephone_number.TelephoneNumber;
import javafx.scene.control.ListCell;
import view.ViewObserver;

public class ViewRowTelephoneNumberAdapter extends ListCell<TelephoneNumber> {
	
	private List<TelephoneNumber> list;
	private ViewObserver observer;
	
	
	

	


	public ViewRowTelephoneNumberAdapter(List<TelephoneNumber> list, ViewObserver observer) {
		super();
		this.list = list;
		this.observer = observer;
	}







	@Override
	public void updateItem(TelephoneNumber param, boolean empty) {
		super.updateItem(param, empty);
		if (param != null) {
			
			ViewRowTelephoneNumber view;
			try {
				view = new ViewRowTelephoneNumber(param, this.list);
				view.addObserver(this.observer);
				setGraphic(view.getRoot());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	

}
