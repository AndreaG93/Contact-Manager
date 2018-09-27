package application.entity.customer;

import javax.persistence.*;
import javax.validation.constraints.*;

import application.gui.javafx.annotation.CallableByRuntimeGeneratedControl;
import application.gui.javafx.annotation.CallableByRuntimeGeneratedTableView;
import application.entity.address.Address;
import application.entity.telephone_number.TelephoneNumber;
import application.persistence.jdbc.annotation.CustomerSetterJDBC;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a customer.
 *
 * @author Andrea Graziani
 * @version 1.0
 */
@Entity
@Table
public class Customer implements Serializable {

    // Constants
    // ============================================================================================================== //

    public static final String COLUMN_ID = "customer_id";
    public static final String COLUMN_REGISTRATION_DATE = "customer_registration_date";
    public static final String COLUMN_NAME = "customer_name";
    public static final String COLUMN_SURNAME = "customer_surname";
    public static final String COLUMN_EMAIL = "customer_email";
    public static final String COLUMN_TITLE = "customer_title";
    public static final String COLUMN_GENDER = "customer_gender";
    public static final String COLUMN_BIRTHDAY = "customer_birthday";

    // Fields
    // ============================================================================================================== //

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = COLUMN_ID, unique = true)
    @NotNull
    private int ID;

    @Column(name = COLUMN_REGISTRATION_DATE)
    @NotNull
    private LocalDate registrationDate;

    @Column(name = COLUMN_NAME, nullable = false)
    @NotEmpty
    @Size(max = 32, message = "Customer name must be less than 32 characters")
    @Pattern(regexp = "[A-Z][a-z]*", message="Customer name is invalid.")
    private String name;

    @Column(name = COLUMN_SURNAME, nullable = false)
    @NotEmpty
    @Size(max = 32, message = "Customer surname must be less than 32 characters")
    @Pattern(regexp = "[A-Z][a-z]*", message="Customer surname is invalid.")
    private String surname;

    @Column(name = COLUMN_EMAIL)
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = COLUMN_TITLE)
    private Title title;

    @Column(name = COLUMN_GENDER)
    private Gender gender;

    @Column(name = COLUMN_BIRTHDAY)
    private LocalDate birthday;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, cascade  = CascadeType.ALL, targetEntity = TelephoneNumber.class)
    @JoinColumn(name = COLUMN_ID)
    private List<TelephoneNumber> telephoneNumbers = new ArrayList<>();

    // Setters
    // ============================================================================================================== //

    @CustomerSetterJDBC(columnName = COLUMN_ID)
    public void setID(int ID) {
        this.ID = ID;
    }

    @CustomerSetterJDBC(columnName = COLUMN_REGISTRATION_DATE)
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @CustomerSetterJDBC(columnName = COLUMN_NAME)
    //@EditableFieldJavaFX(controlLabel = "Nome", promptText = "Inserisci il tuo nome...", controlClassName = "javafx.scene.control.TextField")
    @CallableByRuntimeGeneratedControl
            (promptText = "Inserisci il nome...", description = "Nome", controlType = "RuntimeGeneratedTextField")
    public void setName(String name) {
        this.name = name;
    }

    @CustomerSetterJDBC(columnName = COLUMN_SURNAME)
    @CallableByRuntimeGeneratedControl
            (promptText = "Inserisci il cognome...", description = "Cognome", controlType = "RuntimeGeneratedTextField")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @CustomerSetterJDBC(columnName = COLUMN_TITLE)
    @CallableByRuntimeGeneratedControl
            (description = "Titolo", controlType = "RuntimeGeneratedComboBox")
    public void setTitle(int title) {
        this.title = Title.values()[ (int) title];
    }

    @CustomerSetterJDBC(columnName = COLUMN_GENDER)
    public void setGender(int gender) {
        this.gender = Gender.values()[ (int) gender];
    }

    @CustomerSetterJDBC(columnName = COLUMN_EMAIL)
    public void setEmail(String email) {
        this.email = email;
    }

    @CustomerSetterJDBC(columnName = COLUMN_BIRTHDAY)
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setTelephoneNumbers(List<TelephoneNumber> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // Getters
    // ============================================================================================================== //





    public Customer(String name, String surname, Title title, Gender gender, Address address) {
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.gender = gender;
        this.address = address;
    }

    public Customer() {

    }




    @CallableByRuntimeGeneratedTableView(description = "ID")
    public String getRepresentableId() {
        return String.valueOf(this.ID);
    }

    @CallableByRuntimeGeneratedTableView(description = "Cliente")
    public String getRepresentableName() {
        return String.format("%s. %s %s", this.title.toString(), this.surname, this.name);
    }
    @CallableByRuntimeGeneratedTableView(description = "Data Registrazione")
    public String getRepresentableRegistrationDate() {
        return "";
    }

    @CallableByRuntimeGeneratedTableView(description = "Codice Fiscale")
    public String getRepresentableCodiceFiscale() {
        return "";
    }

    @CallableByRuntimeGeneratedTableView(description = "Data di nascita")
    public String getRepresentableBirthday() {
        return "";
    }


    public List<TelephoneNumber> getTelephoneNumbers() {
        return telephoneNumbers;
    }





    public int getID() {
        return ID;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }


    public String getName() {
        return name;
    }



    public String getSurname() {
        return surname;
    }



    public String getEmail() {
        return email;
    }



    public Title getTitle() {
        return title;
    }



    public Gender getGender() {
        return gender;
    }


    public Address getAddress() {
        return address;
    }


}
