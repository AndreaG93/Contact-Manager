package application.entity.customer;

import javax.persistence.*;

import application.entity.address.Address;
import application.entity.telephone_number.TelephoneNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table
public class Customer implements Serializable {
	
	public static final String COLUMN_ID = "customer_id";
	public static final String COLUMN_NAME = "customer_name";
	public static final String COLUMN_SURNAME = "customer_surname";
	public static final String COLUMN_TITLE = "customer_title";
	public static final String COLUMN_GENDER = "customer_gender";
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = COLUMN_ID, unique = true)
	private int id;

	@Column(name = COLUMN_NAME, nullable = false)
	private String name;

	@Column(name = COLUMN_SURNAME, nullable = false)
	private String surname;

	@Column(name = COLUMN_TITLE)
	private Title title;

	@Column(name = COLUMN_GENDER)
	private Gender gender;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	// private List<String> emailAddresses;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = TelephoneNumber.class)
	@JoinColumn(name = "customer_id")
	private List<TelephoneNumber> telephoneNumbers = new ArrayList<>();

	public List<TelephoneNumber> getTelephoneNumbers() {
		return telephoneNumbers;
	}

	public void setTelephoneNumbers(List<TelephoneNumber> telephoneNumbers) {
		this.telephoneNumbers = telephoneNumbers;
	}

	public Customer(String name, String surname, Title title, Gender gender, Address address) {
		this.name = name;
		this.surname = surname;
		this.title = title;
		this.gender = gender;
		this.address = address;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
