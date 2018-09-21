package application.entity.telephone_number;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table
public class TelephoneNumber implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", unique = true)
	private int id;
	
	@Column(name = "number", nullable = false)
	private String number;
		
	@Column(name = "type")
	private TelephoneNumberType type;

	public TelephoneNumber() {
	}

	
	
	
	public TelephoneNumber(String number, TelephoneNumberType type) {
		super();
		this.number = number;
		this.type = type;
	}


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public TelephoneNumberType getType() {
		return type;
	}

	public void setType(TelephoneNumberType type) {
		this.type = type;
	}

	
	
	
	
	
	
}
