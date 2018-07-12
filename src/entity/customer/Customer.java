package entity.customer;

import entity.address.Address;
import entity.telephone_number.TelephoneNumber;
import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", unique = true)
	private int id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "surname", nullable = false)
	private String surname;

	@Column(name = "title")
	private Title title;

	@Column(name = "gender")
	private Gender gender;

	// private List<String> emailAddresses;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = TelephoneNumber.class)
	@JoinColumn(name = "id")
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

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

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
